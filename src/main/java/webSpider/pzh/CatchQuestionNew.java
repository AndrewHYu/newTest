package webSpider.pzh;

import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrew
 * @date 2018/1/3
 */
public class CatchQuestionNew {
    private static final String URL = "http://218.6.132.18/meol/common/question/questionbank/student/detail.jsp?id=";

    private static final String LIST_URL = "http://218.6.132.18/meol/common/question/questionbank/student/list.jsp?sortColumn=provideTime&chapter=1063&pagingNumberPer=2000&keywords=&knowledgeKey=&Submit=%B2%E9+%D1%AF&sortDirection=-1&questionType=&perm=3840&section=&cateId=42718&pagingPage=2&";

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5, new BufferedThreadFactory());

    private static final ThreadLocal<byte[]> LOCAL_BUFFER = new ThreadLocal<>();

    private static final byte[] fileBuffer = new byte[2048];

    private static final String FILE_PATH ="D:\\projectTest\\must.html";

    private static final String ROOT_PATH ="D:\\projectTest\\";

    private static CloseableHttpClient httpClient = null;
    //输出文件必要的前缀包括css和html格式
    // TODO: 2018/1/3 是否需要 volatile
    private static StringBuilder fileContent = null;

    /**
     * 创建httpClient,加入cookie
     */
    static {
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID","78202DB2439B0F1D7AA1E8509D14FDC6");
        cookie.setDomain("218.6.132.18");
        cookie.setPath("/");
        cookie.setAttribute(ClientCookie.PATH_ATTR, "/");
        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(cookie);

        Header header = new BasicHeader("Content-Type", "text/html;charset=GBK");
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .setDefaultHeaders(headers)
                .build();
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Map<String,String> map = new HashMap<>();
        map.put("1063","骨肿瘤");
        map.put("1060","骨关节结核");
        map.put("1051","骨折概论");
        map.put("1058","运动慢性损伤");
        map.put("1065","血管外科");
        map.put("1054","下肢骨折");
        map.put("1056","关节脱位");
        map.put("1059","骨关节感染");
        map.put("1052","上肢骨折");
        map.put("1069","尿结石");
        map.put("1049","急腹症");
        map.put("1067","泌尿损伤");
        map.put("1071","泌尿肿瘤");
        map.put("1070","尿路梗塞");
        map.put("1062","颈肩腰腿疼");
        map.put("1068","泌尿感染结核");


        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String chapter = iterator.next();
            String outFileName = map.get(chapter) + ".html";
            File file = new File(ROOT_PATH + outFileName);
            if (file.exists())
                file.delete();
            executorService.execute(new Mission(chapter,outFileName));
        }
        fileContent = readFile(FILE_PATH);
        executorService.shutdown();
        if (executorService.awaitTermination(300, TimeUnit.SECONDS)) {
            System.out.println("shutdown");
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        long end = System.nanoTime();
        System.out.println("time: "+(end - start)/1_000_000_000);
    }

    /**
     * 封装任务线程类
     */
    static class Mission implements Runnable{

//        public static final ThreadLocal<Byte[]> buffer = new ThreadLocal<>();
        private String chapter;
        private String outFileName;

        public Mission(String chapter, String outFileName) {
            this.chapter = chapter;
            this.outFileName = outFileName;
        }

        @Override
        public void run() {
            List<String> idList = null;
            try {
                idList = getAllList(chapter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File(ROOT_PATH + outFileName);
            if (file.exists())
                file.delete();

            //添加前缀和css // TODO: 2018/1/3 可能需要优化
            while (fileContent == null);
            outToFile(file, fileContent);
            //爬取题目
            idList.stream()
                    .forEach(id -> readQuestion(id,file));

            //添加后缀
            outToFile(file,new StringBuilder("</body></html>"));
        }
    }

    /**
     * 线程工厂类
     */
    static class BufferedThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        BufferedThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Runnable run = () ->{
                if (LOCAL_BUFFER.get() == null)
                        LOCAL_BUFFER.set(new byte[2048]);
                    r.run();
            };
            Thread t = new Thread(group, run,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    /**
     * 根据文件路径读取文件
     * @param path 问价路径
     * @return 文件内容
     */
    public static StringBuilder readFile(String path){
        StringBuilder content = new StringBuilder();
        try(FileInputStream in = new FileInputStream(new File(path))) {
            for (int length = 0;(length = in.read(fileBuffer)) != -1;){
                content.append(new String(fileBuffer, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    /**
     * 获取该章节的所有题目列表
     * @param chapter 章节代码
     * @return 各个题目id列表
     */
    public static List<String> getAllList(String chapter) throws IOException {
        String chapterString = "chapter=" + chapter;
        String newList = LIST_URL.replace("chapter=1063", chapterString);
        byte[] buffer =  LOCAL_BUFFER.get();

        //http
        HttpGet httpGet = new HttpGet(newList);
        StringBuilder stringBuilder = new StringBuilder();

        CloseableHttpResponse response = httpClient.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() == 200) {
            for (int length = 0;(length = response.getEntity().getContent().read(buffer)) != -1;) {
                String str = new String(buffer, 0, length, "GBK");
                stringBuilder.append(str);
            }
        }

        String pattern = "detail.jsp\\?id=(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(stringBuilder);
        List<String> chapterList = new ArrayList<>();

        String id = "";
        int count = 0;
        while (m.find( )) {
            String i = m.group(1);
            if (!id.equals(i)){
                chapterList.add(i);
                id = i;
            }
            count++;

        }
        System.out.println(count);

        return chapterList;
    }

    /**
     * 将获取到的信息输出到文件
     * @param file 输出文件
     * @param sb 文件内容
     */
    public static void outToFile(File file, StringBuilder sb) {
        try (Writer writer = new FileWriter(file, true)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readQuestion(String id, File file){
        HttpGet httpGet = new HttpGet(URL + id);
        byte[] buffer = LOCAL_BUFFER.get();
        try(CloseableHttpResponse response = httpClient.execute(httpGet)) {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200){
                StringBuilder stringBuilder = new StringBuilder();
                for (int length = 0;(length = response.getEntity().getContent().read(buffer)) != -1;){
                    String str = new String(buffer,0, length, "GBK");
                    stringBuilder.append(str);
                }

                String result = regexFilter(stringBuilder);
                result = result.replaceAll("answer",id);
                outToFile(file, new StringBuilder(result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * g根据正则表达式筛选分组，只支持提取一个分组
     * @param source 源字符串
     * @param pattern 正则表达式
     * @param groupId 分组id
     * @return 获取的分组
     */
    public static List<String> regexFilter(StringBuilder source, String pattern, int groupId){
        List<String> result = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find())
            result.add(m.group(groupId));
        return result;
    }
    public static String regexFilter(StringBuilder source){
        String pattern = "<body.*?>[\\s\\S]*</body>";
        return regexFilter(source, pattern,0).get(0);
    }
}

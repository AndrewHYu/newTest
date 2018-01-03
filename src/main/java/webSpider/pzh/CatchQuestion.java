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
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrew
 * @date 2017/12/27
 */
public class CatchQuestion {
//    CloseableHttpClient httpclient = HttpClients.createDefault();
    private final String URL = "http://218.6.132.18/meol/common/question/questionbank/student/detail.jsp?id=";

    private final String LIST_URL = "http://218.6.132.18/meol/common/question/questionbank/student/list.jsp?sortColumn=provideTime&chapter=1063&pagingNumberPer=2000&keywords=&knowledgeKey=&Submit=%B2%E9+%D1%AF&sortDirection=-1&questionType=&perm=3840&section=&cateId=42718&pagingPage=2&";

    private final byte[] buffer = new byte[2048];
    private final char[] charBuffer = new char[2048];

    private final String SCC_PATH ="D:\\projectTest\\must.html";
    private final String ROOT_PATH ="D:\\projectTest\\";

    private static CloseableHttpClient httpClient = null;

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

    /**
     *
     * http://218.6.132.18/meol/common/question/questionbank/student/detail.jsp?id=56571
     */
    @Test
    public void HttpClientTest(){
//        httpGetString(url);
    }

    @Test
    public void regexTest(){

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
        while (iterator.hasNext()){
            String chapter = iterator.next();
            String outFileName = map.get(chapter) + ".html";
            List<String> idList = getAllList(chapter);
            File file = new File(ROOT_PATH + outFileName);
            if (file.exists())
                file.delete();

            //添加前缀和css
            outToFile(file, getCss(SCC_PATH));
            //爬取题目
            idList.stream()
                    .forEach(id -> httpGetString(id,file));

            //添加后缀
            outToFile(file,new StringBuilder("</body></html>"));

        }
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println("time: "+(end - start)/1_000_000_000);
    }

    public List<String> getAllList(String chapter){
        String chapterString = "chapter=" + chapter;
        String newList = LIST_URL.replace("chapter=1063", chapterString);

        //http
        HttpGet httpGet = new HttpGet(newList);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200) {
                for (int length = 0;(length = response.getEntity().getContent().read(buffer)) != -1;) {
                    String str = new String(buffer, 0, length, "GBK");
                    stringBuilder.append(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    public void httpGetString(String id, File file){
        HttpGet httpGet = new HttpGet(URL + id);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200){
                StringBuilder stringBuilder = new StringBuilder();
                for (int length = 0;(length = response.getEntity().getContent().read(buffer)) != -1;){
                    String str = new String(buffer,0, length, "GBK");
                    stringBuilder.append(str);
                }

                int index1 = stringBuilder.indexOf("<body>");
                int index2 = stringBuilder.indexOf("</body>");
                String result = stringBuilder.substring(index1 + 7, index2);
                result = result.replaceAll("answer",id);
//                System.out.println(stringBuilder.toString());
                outToFile(file, new StringBuilder(result));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StringBuilder getCss(String path){
        StringBuilder css = new StringBuilder();
        try {
            Reader reader = new FileReader(new File(path));
            for (int length = 0;(length = reader.read(charBuffer)) != -1;){
                css.append(String.copyValueOf(charBuffer, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return css;
    }

    public void outToFile(File file, StringBuilder sb){
        try {
            Writer writer = new FileWriter(file,true);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

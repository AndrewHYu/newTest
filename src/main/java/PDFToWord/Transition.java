package PDFToWord;

import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Created by Andrew  on 2017/6/4.
 */
public class Transition {
    public static void main(String[] args) throws IOException {


        PDDocument doc=PDDocument.load(new File("C:\\Users\\27032\\Desktop\\std.pdf"));
        int pagenumber=doc.getNumberOfPages();
        System.out.print("pages"+pagenumber);

        FileOutputStream fos=new FileOutputStream("C:\\Users\\27032\\Desktop\\std.doc");
        Writer writer=new OutputStreamWriter(fos,"UTF-8");
        PDFTextStripper stripper=new PDFTextStripper();

        stripper.setSortByPosition(true);//排序
        //stripper.setWordSeparator("");//pdfbox对中文默认是用空格分隔每一个字，通过这个语句消除空格（视频是这么说的）
     /*   stripper.setStartPage(3);//设置转换的开始页
        stripper.setEndPage(7);//设置转换的结束页*/
        stripper.writeText(doc,writer);
        writer.close();
        doc.close();

    }
}

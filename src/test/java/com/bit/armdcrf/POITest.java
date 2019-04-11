package com.bit.armdcrf;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Debbie Qiu
 */
public class POITest {


    @Test
    public void test(){



        String inputUrl = "/Users/Debbie/Desktop/测试数据/CRF/CRF/CRF03.docx";
        String outputUrl = "//Users/Debbie/Desktop/测试数据/CRF/CRF/CRF03test.docx";

        changeWord(inputUrl,outputUrl);

    }


    public static void changeWord(String inputUrl, String outputUrl ){

        try {
            //获取word文档解析对象
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //获取段落文本对象
            //List<XWPFParagraph> paragraph = document.getParagraphs();
            //获取首行run对象
            //XWPFRun run = paragraph.get(0).getRuns().get(0);
            //设置文本内容
            //XWPFDocument document = new XWPFDocument();



            for(int i=65; i<85;i++){
                XWPFParagraph p=document.getParagraphArray(i);
                System.out.print(i+":"+p.getParagraphText());
                List<XWPFRun> runs = p.getRuns();

                for (int j = runs.size() - 1; j >= 0; j--) {
                    p.removeRun(j);
                }

               // TODO:把段落内的都一点点移除，然后尝试直接写text进去看看


//                List<XWPFRun> runList = p.getRuns();
//                for (XWPFRun xwpfRun : runList) {
//                    System.out.print(xwpfRun.toString());
//                }
//                XWPFRun runn =  p.createRun();
//                runn.setText("丙型肝炎病史：☒有  ☐无；");



            }

            //生成新的word
            File file = new File(outputUrl);

            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

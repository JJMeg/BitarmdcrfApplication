package com.bit.armdcrf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Debbie Qiu
 */
public class LineNumberTest {

    @Test
    public  void  lineNumberTest(){


    XWPFDocument doc = null;
    String content = "";
    try {
    InputStream is = new FileInputStream("/Users/Debbie/Desktop/CRF/CRF/CRF0.docx");//TODO:待改为URI，对应整个Word文档
    //InputStream is = new FileInputStream(uri);//TODO:待改为URI，对应整个Word文档
        doc = new XWPFDocument(is);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    int startLine = 65;
    int endLine = 85;
    System.out.print(doc.getParagraphArray(startLine).getParagraphText());
   // if(doc.getParagraphArray(startLine).getParagraphText().startsWith("CRF-1：病例资料")) {
    for (int i = startLine + 1; i < endLine; i++) {
        System.out.print(doc.getParagraphArray(i).getParagraphText() +"\n");
    }
        System.out.print("End");

/*
    try {
        throw new CRFLineNumberException("文档第"+ startLine +"段不是CRF-1标题");
    } catch (CRFLineNumberException e) {
        e.printStackTrace();
    }*/


}
}

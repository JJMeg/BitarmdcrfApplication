package com.bit.armdcrf.service.CrfResolve;

import com.bit.armdcrf.dictionary.KeyWordName;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.entity.Keyword;
import com.bit.armdcrf.other.CrfHandler;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class TableToWord {

    @Deprecated
    public String Crf1_1(Map<String,String> crf){

        List<Keyword> keywords = CrfKeyWord.getKeyWords(KeyWordName.getPath(1,1));


        return "";


    }

    public void toWord(String uri,String sUri,Crf crf){
        int sLine = crf.getStartLine()+2;
        int eLine = crf.getEndLine();
        String content = CrfHandler.crfToWord(crf);
        String[] cons = content.split(",");

        try {
            //获取word文档解析对象
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(uri));
            int a = 0;
            for(int i=sLine;i<eLine;i++,a++){
                XWPFParagraph p=document.getParagraphArray(i);

                // TODO:把段落内的都一点点移除，然后尝试直接写text进去看看


                List<XWPFRun> runs = p.getRuns();
                for (int j = runs.size() - 1; j >= 0; j--) {
                    p.removeRun(j);
                }
                if(a<cons.length) {
                    XWPFRun runn = p.createRun();
                    runn.setText(cons[a]);
                }
            }

            //生成新的word
            File file = new File(sUri);

            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

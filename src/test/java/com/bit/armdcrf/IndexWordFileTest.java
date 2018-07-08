package com.bit.armdcrf;

import com.bit.armdcrf.dictionary.CRFLineNumber;
import com.bit.armdcrf.entity.Crf_Field.*;
import com.bit.armdcrf.service.IndexHandler.IndexFile.IndexWordImpl;
import com.bit.armdcrf.service.Interface.WordDataAcquire;
import org.apache.lucene.document.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Paths;


/**
 * @author Debbie Qiu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexWordFileTest {

    @Autowired
    IndexWordImpl indexWordImpl;

    @Autowired
    WordDataAcquire wordDataAcquire;

    @Autowired
    Crf_Field_preLabStudy crf_field_preLabStudy;

    @Test
    public void regTest() {
        String content = wordDataAcquire.getLineContent(CRFLineNumber.Crf2[1][0], CRFLineNumber.Crf2[1][1], "/Users/Debbie/Desktop/CRF/CRF/CRF0.docx");
        String reg = "病灶" + "[1-3]\\d*" + "：";
        String[] contents = content.split(reg);
        System.out.print(contents);
    }

    @Test
    public void getFeildTest() throws IOException {
        indexWordImpl.createWriter();
        indexWordImpl.fileIndexCreate(Paths.get("/Users/Debbie/Desktop/CRF/CRF/CRF0.docx"));
        indexWordImpl.closeWriter();
    }

    @Test
    public void setFieldTest() {
        indexWordImpl.setDocument(new Document());
        String uri = "/Users/Debbie/Desktop/CRF/CRF/CRF0.docx";
        //indexWordImpl.setDocument(new Document());
        indexWordImpl.setCrf1Field(uri);
        //indexWordImpl.setField("/Users/Debbie/Desktop/CRF/CRF/CRF0.docx");
    }

}











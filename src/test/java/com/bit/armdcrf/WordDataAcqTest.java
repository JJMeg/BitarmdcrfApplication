package com.bit.armdcrf;

import com.bit.armdcrf.service.Interface.WordDataAcquire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordDataAcqTest {
    @Autowired
    WordDataAcquire wordDataAcquire;

    @Test
    public void getMapTest(){
       // wordDataAcquire.getCRFValueList(2, 4, "/Users/Debbie/Desktop/CRF/CRF/CRF0.docx");

    }

    @Test
    public void getFieldMapTest(){
       //Map<String,String> map =  wordDataAcquire.getFieldMap(2,1,"/Users/Debbie/Desktop/CRF/CRF/CRF0.docx");
       //System.out.print(map.toString());

    }



    @Test
    public void getContentTest(){
        String content = wordDataAcquire.getWholeWord("/Users/Debbie/Desktop/CRF/CRF/CRF20.docx");
        System.out.print(content);
    }

}

package com.bit.armdcrf;

import com.bit.armdcrf.service.DataHandler.WordDataHandlerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Debbie Qiu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordDataHandlerImplTest {
    @Autowired
    WordDataHandlerImpl wordDataHandlerImpl;

    @Test
    public void addTest(){
        wordDataHandlerImpl.add("/Users/Debbie/Desktop/CRF/CRF");

    }


    public void setFeildTest(){
        //wordDataHandler.setFeild("s");

    }

}

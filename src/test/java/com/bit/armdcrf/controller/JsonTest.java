package com.bit.armdcrf.controller;


import com.alibaba.fastjson.JSONObject;
import com.bit.armdcrf.entity.Crf.Crf2_1;

import org.junit.Test;

/**
 * @author Debbie Qiu
 */
public class JsonTest {

    @Test
    public void  test(){

        Crf2_1 crf2_1 =new Crf2_1();

        crf2_1.setCEA("1");

        String string= JSONObject.toJSONString(crf2_1);

        System.out.print(string);

    }
}

package com.bit.armdcrf.controller;

import com.bit.armdcrf.entity.Crf.Crf2_1;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Debbie Qiu
 */
public class JavaBeanTest {

    @Test
    public void test(){

        Crf2_1 crf2_1 = new Crf2_1();
        try {
            testReflect(crf2_1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void testReflect(Object model) throws Exception{
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.getName().equals("SFT"))

                field.set(model, "1");

            System.out.println(field.getName() + ":" + field.get(model) );
        }
    }
}

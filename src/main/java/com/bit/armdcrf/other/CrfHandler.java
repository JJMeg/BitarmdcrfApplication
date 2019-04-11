package com.bit.armdcrf.other;

import com.bit.armdcrf.dictionary.CodeToValue;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.entity.Crf.Crf2_1;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Debbie Qiu
 * 将从文档中解析出来的键值对映射到对应的java实体类中
 */
public class CrfHandler {





    public static Crf mapToCrf(Crf model,Map<String,String> value,Map<String,String> dict){
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                field.set(model,value.get(dict.get(field.getName())));
                System.out.println(field.getName() + ":" + field.get(model));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return model;
    }



    public static String crfToWord(Crf model){
        Map<String,String> value = model.getDict();
        String result = "";
        int i =0;
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(i == 3) {
                i = 0;
                result += ",";
            }
            try {
                result += value.get(field.getName()) + ":" + field.get(model)+"     ";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            i++;
        }
        return result;
    }

    public static Crf getCrfModel(String part){
        String[] no = part.split("-");
        int part1 = Integer.parseInt(no[0]);
        int part2 = Integer.parseInt(no[1]);

        if(part1 == 1)
            ;
        else if(part1 == 2){
            if(part2 == 1)
                return new Crf2_1();
        }


        return null;

    }

    public static Map<String,String> getCrfDict(String part){
        CodeToValue codeToValue = new CodeToValue();
        String[] no = part.split("-");
        int part1 = Integer.parseInt(no[0]);
        int part2 = Integer.parseInt(no[1]);

        //int part3 = Integer.parseInt(no[2]);

        if(part1 == 1)
            ;
        else if(part1 == 2){
            if(part2 == 1){
                Map<String ,String> dict = codeToValue.getLabStudy();
                dict.putAll(codeToValue.getCrf_2_1());
                return dict;
            }

        }


        return null;

    }
}

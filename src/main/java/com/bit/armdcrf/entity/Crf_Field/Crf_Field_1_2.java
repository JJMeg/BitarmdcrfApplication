package com.bit.armdcrf.entity.Crf_Field;

import com.bit.armdcrf.dictionary.CodeToValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
//TODO：尝试把治疗方式放到两个类型的Feild当中，对搜索结果会有怎样的影响呢（因为既想要准确检索选项卡，也想索引其它项）
    //TODO:待改，把病史当做值放到Field的值域里面进行 分词 搜索最好
@Component
public class Crf_Field_1_2 extends CrfField{
    private List<String> history;

    private CodeToValue codeToValue;
    private Map<String,String> value;


    @Autowired
    public Crf_Field_1_2(CodeToValue codeToValue) {
        super();
        this.codeToValue = codeToValue;
        value = codeToValue.getCrf_1_2();

        STORE_ATOM = Arrays.asList();
        NORMAL_ATOM = Arrays.asList(value.get("history"),value.get("treat_method"),value.get("liver_trans_result"),
                value.get("symptom"),value.get("sign"),value.get("compl"),value.get("neopathy"));
        NORMAL_NO_ATOM = Arrays.asList(value.get("medicineName"),value.get("treat_method"),value.get("history"));
        INT_STORE = Arrays.asList(value.get("cureTime"),value.get("operation_number"),value.get("focus_numer"),value.get("treat_focus"));

    }

    private void getHistory(){

        history = Arrays.asList(value.get("hepB"),value.get("hepC"),value.get("drunk"),value.get("chemical"),
        value.get("medical"),value.get("operation"),value.get("mini_invasive"),value.get("liver_trans"));
    }


    /**
     * 将原来格式的值为是或否的病史条例放入一个相关病史的集合中，方便后续的检索操作
     * @param rawField
     * @return
     */
    public Map<String,String> finalHandle(Map<String,String> rawField){
        getHistory();
        Map<String,String> field = new IdentityHashMap<>(); //可以存放值相同的key
        for (Map.Entry<String, String> entry : rawField.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(history.contains(key)){
                if(value.equals("是") || value.equals("有")) {
                    value = key;
                    key = "相关病史";
                    field.put(new String(key), value);
                }
            }
            else{
                field.put(new String(key),value);
            }
           /* if(key.equals("治疗方式")){
                key = "微创治疗方式"
                field.put("")
            } */

        }
        return field;
    }
}


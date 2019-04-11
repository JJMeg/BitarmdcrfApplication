package com.bit.armdcrf.entity.Crf_Field;

import com.bit.armdcrf.dictionary.CodeToValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class Crf_Field_1_1 extends CrfField {

    private CodeToValue codeToValue;
    @Autowired
    public Crf_Field_1_1(CodeToValue codeToValue) {
        super();
        this.codeToValue =codeToValue;
        Map<String,String> value = codeToValue.getCrf_1_1();
        STORE_ATOM = Arrays.asList(value.get("hospitalID"),value.get("caseID"),value.get("date"),value.get("name"),value.get("sex"));
        NORMAL_ATOM = Arrays.asList(value.get("contact"),value.get("homephone"),value.get("cellphone"),value.get("workphone"));
        NORMAL_NO_ATOM = Arrays.asList();
        INT_STORE = Arrays.asList(value.get("age"));
    }



}

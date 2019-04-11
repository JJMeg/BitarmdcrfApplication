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
public class Crf_Field_PreCEUS extends CrfField{
    private CodeToValue codeToValue;
    @Autowired
    public Crf_Field_PreCEUS(CodeToValue codeToValue) {
        super();
        this.codeToValue =codeToValue;
        Map<String,String> value = codeToValue.getPreFocus();
        // STORE_ATOM = Arrays.asList(value.get(""));
        FLOAT_STORE = Arrays.asList(value.get("FUSLong"),value.get("FUSWidth"),value.get("FUSDeep"));

        NORMAL_ATOM = Arrays.asList("all",value.get("FUSLong"),value.get("FUSWidth"),value.get("FUSDeep"));

    }


    /*public Map<String,String> postHandler(){

    }*/
}

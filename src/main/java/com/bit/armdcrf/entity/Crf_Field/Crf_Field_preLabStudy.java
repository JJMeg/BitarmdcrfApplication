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
public class Crf_Field_preLabStudy extends CrfField{
//TODO:数据到底怎么存，数据还是得精确保存，等着精确检索
    private CodeToValue codeToValue;
    @Autowired
    public Crf_Field_preLabStudy(CodeToValue codeToValue) {
        super();
        this.codeToValue =codeToValue;
        Map<String,String> value = codeToValue.getLabStudy();
        Map<String,String> value_extra = codeToValue.getCrf_2_1();
       // STORE_ATOM = Arrays.asList(value.get(""));
        FLOAT_STORE = Arrays.asList("all",value.get("preLabStudy"),value.get("FOBT"),value.get("SFT"),value.get("labStudy"),
                value.get("TMDetection"),value.get("bloodRT"),value.get("bloodBC"),value.get("urineRT"),
                value.get("otherTest"),value.get("CFDetection"),value_extra.get("ChildPugh"),value_extra.get("ZPS"),value_extra.get("recorder"));

        NORMAL_ATOM = Arrays.asList(value.get("FOBT"),value.get("SFT"),value.get("labStudy"),
                value.get("TMDetection"),value.get("bloodRT"),value.get("bloodBC"),value.get("urineRT"),
                value.get("otherTest"),value.get("CFDetection"),value.get("preLabStudy"),value_extra.get("ChildPugh"),value_extra.get("ZPS"),value_extra.get("recorder"));



    }



}

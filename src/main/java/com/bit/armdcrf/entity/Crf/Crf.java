package com.bit.armdcrf.entity.Crf;

import com.bit.armdcrf.dto.WordData;

import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public interface Crf {
    public int getStartLine();
    public int getEndLine();

    public Map<String,String> getDict();

}

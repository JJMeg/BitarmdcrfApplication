package com.bit.armdcrf.service.Interface;

import com.bit.armdcrf.dto.ImgData;
import com.bit.armdcrf.dto.WordData;

import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public interface IndexSearch {
    //public WordData advancedSearchWord(Map<String,Map<String,String>> termSet);
    public List<WordData> searchWord(String search);
    public List<WordData> searchWord(Map<String,Map<String,String>> termSet);
    public List<String> searchWordId(String search);
    public List<String> searchWordId(Map<String,Map<String,String>> termSet);

}

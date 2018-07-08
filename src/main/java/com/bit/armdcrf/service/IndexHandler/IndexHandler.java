package com.bit.armdcrf.service.IndexHandler;

import com.bit.armdcrf.dto.WordData;
import com.bit.armdcrf.service.Interface.IndexSearch;

import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public class IndexHandler {

    public boolean addFileIndex(){
        return false;
    }
    public boolean deleteFileIndex(){
        return false;
    }
    public WordData searchWord(String parse){
        return null;
    }
    public WordData searchWord(Map<String,Map<String,String>> termSet){
        return null;
    }
    public List<String> searchWordId(String parse){
        return null;
    }
    public List<String> searchWordId(Map<String,Map<String,String>> termSet){
        return null;
    }

}

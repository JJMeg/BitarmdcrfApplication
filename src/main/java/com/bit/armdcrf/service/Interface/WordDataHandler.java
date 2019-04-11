package com.bit.armdcrf.service.Interface;

import com.bit.armdcrf.dto.SearchData;
import com.bit.armdcrf.dto.WordData;
import com.bit.armdcrf.entity.Crf.Crf;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Debbie Qiu
 */

public interface WordDataHandler {

    public boolean add(String uri);
    public List<WordData> search(String search);
    public List<WordData> advancedSearch(SearchData searchData);
    public List<String> searchWordId(SearchData searchData);
    public List<String> searchWordIdByExpress(String data);
    public Crf viewWord(String uri, String part);
    public void updateWord(Crf crf,String uri);
}

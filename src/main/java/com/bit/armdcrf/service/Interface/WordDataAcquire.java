package com.bit.armdcrf.service.Interface;

import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public interface WordDataAcquire {

    public String getWholeWord(String uri);

    public String getCrfContent(int crf,String uri);

    public String getCrfPartContent(String crfPart,String uri);

    public String getLineContent(int sLine,int eLine,String uri);

    public Map<String, String> getPartFieldMap(String keywordName, String content);

    public Map<String, String> getElementFieldMap(String keywordName, String content);

    public List<String> getCrfPartLines(String crfPart,String uri);


}

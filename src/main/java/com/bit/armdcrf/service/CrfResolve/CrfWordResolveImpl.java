package com.bit.armdcrf.service.CrfResolve;


import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.exception.keyword.KeyWordRepeatException;
import com.bit.armdcrf.exception.keyword.UnitCheckBoxKeyWordException;
import com.bit.armdcrf.service.Interface.CrfWordResolve;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 * @author Debbie Qiu
 *
 */

@Component
public class CrfWordResolveImpl implements  CrfWordResolve{


    private static Logger logger = LogManager.getLogger(CrfWordResolveImpl.class);
    @Autowired
    WordToTable wordToTable;
    @Autowired
    TableToWord tableToWord;


    @Override
    public Map<String, String> WordToTable(String content, String fileName)
            throws KeyWordRepeatException, UnitCheckBoxKeyWordException {
        return wordToTable.WordToTable(content,fileName);
    }

    @Override
    public void TableToWord(String uri,String sUri,Crf crf){
        tableToWord.toWord(uri,sUri,crf);
    }




}

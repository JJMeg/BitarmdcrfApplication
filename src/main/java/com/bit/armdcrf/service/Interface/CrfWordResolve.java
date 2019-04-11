package com.bit.armdcrf.service.Interface;

import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.exception.keyword.KeyWordRepeatException;
import com.bit.armdcrf.exception.keyword.UnitCheckBoxKeyWordException;

import java.util.Map;

/**
 * @author Debbie Qiu
 */
public interface CrfWordResolve {


        /**
         * 根据对应关键字文本提取文档内容.
         * @param content 待处理的文档字符串内容
         * @param fileName 关键字文本文件的名称
         * @return 处理结果的key-value键值对
         * @throws UnitCheckBoxKeyWordException 关键字类型异常
         * @throws KeyWordRepeatException 关键字重复异常
         */
        public Map<String, String> WordToTable(String content, String fileName)
                throws UnitCheckBoxKeyWordException,KeyWordRepeatException;
        //public String tableToWord();

        public void TableToWord(String uri,String sUri,Crf crf);



}

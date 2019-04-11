package com.bit.armdcrf.service.CrfResolve;

import com.bit.armdcrf.entity.enums.KeywordTypeEnum;

import com.bit.armdcrf.exception.keyword.KeyWordRepeatException;
import com.bit.armdcrf.exception.keyword.UnitCheckBoxKeyWordException;
import com.bit.armdcrf.exception.keyword.keyWordNotMatch;
import com.bit.armdcrf.entity.Keyword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class WordToTable {

    private static Logger logger = LogManager.getLogger(WordToTable.class);

    public Map<String, String> WordToTable(String content, String fileName)
            throws UnitCheckBoxKeyWordException,KeyWordRepeatException {
        logger.info("开始处理对应文档" + fileName.substring(0,fileName.length()-4)+ "部分的内容。");
        // TODO Auto-generated method stub
        /*
         *
         * Author:debbie
         * Content:目前添加了处理填空部分信息的提取代码。
         * Param:content是整个待处理的表格块被联合处理成的一整条字符串，建议在之前去除一些不需要的信息。
         * Time:2018-1-6 21:08
         */
        Map<String, String> wordResultMap = new LinkedHashMap<String, String>();
        List<Keyword> keywords = CrfKeyWord.getKeyWords(fileName);

        Keyword keyword = null;

        for (int i = 0; i < keywords.size(); i++) {

            int endIndex = -1;
            int beginIndex = 0;
            keyword = keywords.get(i);

            if (keyword.getContent().contains("@") || keyword.getContent().contains("&"))  //如果该项含有单位或者是选项卡
            {
                try {
                    throw new UnitCheckBoxKeyWordException();
                } catch (UnitCheckBoxKeyWordException e) {
                    logger.error("word文档模板格式错误，可能有包含不正确的单位或者选项卡内容+'"+keyword+"'！");
                    e.printStackTrace();
                    throw new UnitCheckBoxKeyWordException();
                }
            }
            else if(i == keywords.size()-1)   //如果已经是最后一个关键字
            {
                String value = "";
                String key = keyword.getContent();
                if(keyword.getContent().startsWith("!")) {
                    key = key.substring(1);
                }

                beginIndex = getBeginIndex(content,key) + key.length();
                value = content.substring(beginIndex).trim();
                value = filterPunc(value);

                if(keyword.getContent().startsWith("!")) {
                    Map<String,String> size = sizeHandler(value);
                    for(Map.Entry<String, String> entry : size.entrySet())
                        wordResultMap.put(entry.getKey(), entry.getValue());
                }
                else{
                    value = filterPunc(value);
                    wordResultMap.put(keyword.getContent(), value);
                }
               // wordResultMap.put(key, value);
            }
            else if(keyword.getContent().startsWith("*"))
            {
                String key = keyword.getContent();
                key = key.substring(1,key.length());
                endIndex = getBeginIndex(content,key) + keyword.getContent().length();
                content = content.substring(endIndex);
                wordResultMap.put(key, "有");
            }
            else
            {
                Keyword nextKeyword = keywords.get(i + 1);
                if (keyword.getContent().equals(nextKeyword.getContent())) {
                    try {
                        throw new KeyWordRepeatException();
                    } catch (KeyWordRepeatException e) {
                        logger.error("word文档模板格式错误，可能含有重复的关键字'" + nextKeyword + "'！");
                        e.printStackTrace();
                        throw new KeyWordRepeatException();
                    }
                }
                if (nextKeyword.getKeywordType() == KeywordTypeEnum.KEYWORD) {
                    String value = "";
                    String key = keyword.getContent();
                    String nextKey = nextKeyword.getContent();
                    if(keyword.getContent().startsWith("!")) {
                        key = key.substring(1);
                    }
                    if(nextKeyword.getContent().startsWith("!")) {
                        nextKey = nextKey.substring(1);
                    }

                    beginIndex = getBeginIndex(content,key) + key.length();
                    endIndex = getBeginIndex(content,nextKey);

                    value = content.substring(beginIndex, endIndex).trim();

                    //是否为待处理的病灶大小信息
                    if(keyword.getContent().startsWith("!")) {
                        Map<String,String> size = sizeHandler(value);
                        for(Map.Entry<String, String> entry : size.entrySet())
                            wordResultMap.put(entry.getKey(), entry.getValue());
                    }
                    else{
                        value = filterPunc(value);
                        wordResultMap.put(keyword.getContent(), value);
                    }
                    content = content.substring(endIndex);

                } else if (nextKeyword.getKeywordType() == KeywordTypeEnum.UNIT) {
                    String value = "";
                    beginIndex = getBeginIndex(content,keyword.getContent()) + keyword.getContent().length();
                    String tempContent  = content.substring(beginIndex);
                    endIndex = beginIndex + getBeginIndex(tempContent,nextKeyword.getContent());
                    value = content.substring(beginIndex, endIndex).trim();
                    value = filterPunc(value);
                    String comKeyword = keyword.getContent().substring(0, keyword.getContent().length() - 1) +
                            "(" + nextKeyword.getContent() + "):";
                    wordResultMap.put(comKeyword, value);
                    content = content.substring(endIndex + nextKeyword.getContent().length());
                    i++;   //跳过单位关键字，进入下一个待处理关键字

                } else if (nextKeyword.getKeywordType() == KeywordTypeEnum.CHECKBOX) {
                    String value = "";
                    String checkItem = "";
                    Keyword perKeyword = keyword;
                    do {
                        i++;  //当前处理的关键字在集合中的Index
                        beginIndex = getBeginIndex(content,perKeyword.getContent()) + perKeyword.getContent().length();
                        content  = content.substring(beginIndex);
                        endIndex = getBeginIndex(content,nextKeyword.getContent());
                        checkItem = nextKeyword.getContent();
                        if(checkItem.equals("其它"))
                        {
                            int index = 0 ;
                            if(keywords.size() > (i + 1)){
                               index  =  getBeginIndex(content,keywords.get(i+1).getContent());
                            }
                            else{
                                index = content.length();
                            }
                            checkItem = content.substring(endIndex+nextKeyword.getContent().length(),index).trim();

                        }


                        String tempValue = content.substring(0, endIndex).trim();

                        if (tempValue.equals("☐"))
                            value += "#0" + checkItem;
                        else if (tempValue.equals("☒"))
                            value += "#1" + checkItem;
                        perKeyword = nextKeyword;
                        if( i < keywords.size()-1)
                            nextKeyword = keywords.get(i+1);
                        else
                            break;

                    } while (nextKeyword.getKeywordType() == KeywordTypeEnum.CHECKBOX);
                    wordResultMap.put(keyword.getContent(), value);
                    if(i < keywords.size()-1)   //还未处理到最后一个值
                        content = content.substring(endIndex + perKeyword.getContent().length()); //最后处理的那个关键字的索引值
                }


            }
        }
        logger.info("文档解析到键值对成功!");
        /**
         *TEST
         *
         * TODO：将map封装入JSON,前端根据相关规则对checkbox部分进行解析处理
         *
         */
        for (Map.Entry<String, String> entry : wordResultMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        return wordResultMap;

    }




    /**
     * 去除关键字多余的标点符号后缀
     *
     * @param value 初步截取的raw字符串
     * @return 去除标点符号的字符串
     */
    public String filterPunc(String value) {
        if (!value.equals(""))
            if (value.charAt(value.length() - 1) == ',' || value.charAt(value.length() - 1) == '，'
                    || value.charAt(value.length() - 1) == '；' || value.charAt(value.length() - 1) == ';'
                    || value.charAt(value.length() - 1) == '。' || value.charAt(value.length() - 1) == '.')
                value = value.substring(0, value.length() - 1).trim();
        return value;
    }

    /**
     * 防止文档内部因为冒号格式不一致导致匹配错误
     * @param content
     * @param keyword
     * @return
     */
    public int getBeginIndex(String content,String keyword){
        int startIndex = content.indexOf(keyword);
        if( startIndex == -1){
            String kw = keyword;
            if(kw.substring(kw.length()-1,kw.length()).equals("："))
                kw = kw.substring(0,kw.length()-1)+":";
            else if(kw.substring(kw.length()-1,kw.length()).equals(":"))
                kw = kw.substring(0,kw.length()-1)+"：";
            startIndex = content.indexOf(kw);
            if(startIndex == -1)
                try {
                    throw new keyWordNotMatch("关键字" + keyword + "无法在文档内容中匹配到!");
                } catch (com.bit.armdcrf.exception.keyword.keyWordNotMatch keyWordNotMatch) {
                    keyWordNotMatch.printStackTrace();
                }

        }
        return startIndex;
    }

    public Map<String,String> sizeHandler(String value){
        Map<String,String> size = new HashMap<>();
        String[] values = value.split("cm x");
        size.put("长:",values[0].trim());
        size.put("宽:",values[1].trim());
        size.put("深:",values[2].substring(0,values[2].length()-3).trim());
        return size;

    }

}

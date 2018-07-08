package com.bit.armdcrf.service.DataAcquire;

import com.bit.armdcrf.dictionary.CRFLineNumber;
import com.bit.armdcrf.entity.Crf.Crf1_1;
import com.bit.armdcrf.exception.keyword.KeyWordRepeatException;
import com.bit.armdcrf.exception.keyword.UnitCheckBoxKeyWordException;
import com.bit.armdcrf.service.Interface.CrfWordResolve;
import com.bit.armdcrf.service.Interface.WordDataAcquire;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class WordDataAcquireImpl implements WordDataAcquire {
    @Autowired
    CrfWordResolve wordResolve;


    /**
     *
     * 根据关键字名和内容获取解析好的用于设置Field的键值对
     * @param keywordName
     * @param content
     * @return
     */
    @Override
    public Map<String, String> getPartFieldMap(String keywordName, String content) {
        Map<String, String> wordResultMap=  null;
        try {
           wordResultMap = wordResolve.WordToTable(content, keywordName);
        } catch (UnitCheckBoxKeyWordException e) {
            e.printStackTrace();
        } catch (KeyWordRepeatException e) {
            e.printStackTrace();
        }
        return getFieldMap(wordResultMap);
    }
    /**
     * 获取有重复单元模板的内容，例如术前的US的三个病灶表，主要判断该表格中是否存储有有效信息
     * @return
     */
    @Override
    public Map<String, String> getElementFieldMap(String keywordName, String content) {

        Map<String,String> fieldMap= new IdentityHashMap<String ,String>();
        try {
            Map<String, String> wordResultMap = wordResolve.WordToTable(content, keywordName);
            for (Map.Entry<String, String> entry : wordResultMap.entrySet()) {
                if(!entry.getValue().equals("") || entry.getValue().contains("#1有")) {  //如果保留的第一个值为空在，则证明该单元未填写，无需记录
                    fieldMap = getPartFieldMap(keywordName, content);
                    break;
                }
                else
                    return fieldMap;

            }


        } catch (UnitCheckBoxKeyWordException e) {
            e.printStackTrace();
        } catch (KeyWordRepeatException e) {
            e.printStackTrace();
        }


        return fieldMap;
    }

    /**
     * 获取word文档中所有的除标题页外的内容
     * @param uri
     * @return
     */
    @Override
    public String getWholeWord(String uri){
        String content = "";

        XWPFDocument doc = getDocument(uri);
        int startLine = CRFLineNumber.getCrfStart(1,1);
        int endLine = doc.getParagraphs().size();
        System.out.print(doc.getParagraphArray(startLine).getParagraphText());
        for (int i = startLine ; i < endLine; i++) {
            content += doc.getParagraphArray(i).getParagraphText() +"\n\n";
        }
        return content;
    }

    @Override
    public String getLineContent(int sLine,int eLine,String uri){
        XWPFDocument doc = getDocument(uri);
        String content = "";
        System.out.print(doc.getParagraphArray(sLine).getParagraphText());
        //  if(doc.getParagraphArray(startLine).getParagraphText().startsWith("CRF-1：病例资料")) {
        for (int i = sLine ; i < eLine; i++) {
            content += doc.getParagraphArray(i).getParagraphText() +"\n\n";
        }
        //  }
      /*  else{
            try {
                throw new CRFLineNumberException("文档第"+ startLine +"段不是CRF-1标题");
            } catch (CRFLineNumberException e) {
                e.printStackTrace();
            }
        }*/
        return content;
    }

    public List<String > getLineLists(int sLine,int eLine,String uri){
        XWPFDocument doc = getDocument(uri);
        List<String> content = new LinkedList<>();
        System.out.print(doc.getParagraphArray(sLine).getParagraphText());

        for (int i = sLine ; i < eLine; i++) {
            String con = doc.getParagraphArray(i).getParagraphText();
            if(!con.trim().equals(""))
                content.add(doc.getParagraphArray(i).getParagraphText());
        }

        return content;
    }
    /**
     * 根据表编号来从文档中获取对应的内容
     * @param crf
     * @return
     */
    @Override
    public String getCrfContent(int crf,String uri){
        //String content = "";
        int startLine = CRFLineNumber.crf[crf-1][0];
        int endLine = CRFLineNumber.crf[crf-1][1];
        return getLineContent(startLine,endLine,uri);
    }
    /**
     * 根据表和部分的编号来从文档中获取对应的内容
     * @param
     * @return
     */
    @Override
    public String getCrfPartContent(String crfPart,String uri){
        String[] numbers = crfPart.split("-");
        int crf = Integer.parseInt(numbers[0]);
        int part = Integer.parseInt(numbers[1]);
        int startLine = CRFLineNumber.crfPart[crf-1][part-1][0];
        int endLine = CRFLineNumber.crfPart[crf-1][part-1][1];
        return getLineContent(startLine,endLine,uri);
    }

    /**
     * 返回用于展示在前端的行格式内容
     * @return
     */
    @Override
    public List<String> getCrfPartLines(String crfPart,String uri){
        String[] numbers = crfPart.split("-");
        int crf = Integer.parseInt(numbers[0]);
        int part = Integer.parseInt(numbers[1]);
        int startLine = CRFLineNumber.crfPart[crf-1][part-1][0];
        int endLine = CRFLineNumber.crfPart[crf-1][part-1][1];
        return getLineLists(startLine,endLine,uri);
    }


    public Map<String, String> getFieldMap(Map<String,String> wordResultMap) {

        Map<String,String> fieldMap= new IdentityHashMap<String ,String>();

        for (Map.Entry<String, String> entry : wordResultMap.entrySet()) {

            String value = entry.getValue();
            String key = entry.getKey();
            key = key.substring(0, key.length() - 1); //去除掉最后的冒号

            //TODO:如果既有单位又有选项卡的情况
            if (key.endsWith(")")) {
                String[] values = key.split("\\(");
                key = values[0];
                fieldMap.put(key, value);
            } else if (value.contains("#")) {
                String selected = "";
                String[] values = value.split("#");
                for (String v : values) {
                    if (v.startsWith("1")) {
                        value = v.substring(1, v.length());
                        fieldMap.put(new String(key), value); //在IdentityMap中放入值相同hashcode不同的key值
                    }
                }
            } else {
                fieldMap.put(key, value);
            }
        }

        return fieldMap;
    }

    public XWPFDocument getDocument(String uri){
        XWPFDocument doc = null;
        try {
            //InputStream is = new FileInputStream("/Users/Debbie/Desktop/CRF/CRF.docx");//TODO:待改为URI，对应整个Word文档
            InputStream is = new FileInputStream(uri);//TODO:待改为URI，对应整个Word文档
            doc = new XWPFDocument(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }




}

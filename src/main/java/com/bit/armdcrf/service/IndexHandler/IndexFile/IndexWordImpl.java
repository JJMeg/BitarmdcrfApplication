package com.bit.armdcrf.service.IndexHandler.IndexFile;


import com.bit.armdcrf.dictionary.CRFLineNumber;
import com.bit.armdcrf.dictionary.KeyWordName;
import com.bit.armdcrf.entity.Crf_Field.*;
import com.bit.armdcrf.exception.index.IndexWriterException;
import com.bit.armdcrf.service.Interface.IndexWord;
import com.bit.armdcrf.service.Interface.WordDataAcquire;

import nlpir.lucene.cn.ictclas.NLPIRTokenizerAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;

import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.lucene.document.Field.*;

@Component
public class IndexWordImpl implements IndexWord{

    public final String indexDir = System.getProperty("user.dir") +"/indexFile";
    private Directory directory ;
    private IndexWriter writer ;
    int partINumber = 1;
    int partIINumber = 1;


    String keyWord;

    Document document ;

    @Autowired
    WordDataAcquire wordDataAcquire;
    @Autowired
    Crf_Field_1_1 crf_field_1_1;
    @Autowired
    Crf_Field_1_2 crf_field_1_2;
    @Autowired
    Crf_Field_preLabStudy crf_field_preLabStudy;
    @Autowired
    Crf_Field_PreUS crf_field_preUS;
    @Autowired
    Crf_Field_PreMRI crf_field_preMRI;
    @Autowired
    Crf_Field_PreCT crf_field_preCT;
    @Autowired
    Crf_Field_PreCEUS crf_field_preCEUS;
    @Autowired
    Crf_Field_PrePETCT crf_field_prePETCT;



    public boolean fileIndexCreate(Path file) throws IOException {

        if(!Files.isReadable(file)){
            System.out.println("Document directory'" + file.toAbsolutePath()+"' dose not exist or is not readable," +
                    "please check the path");
        }


       // writer = getWriter();
        if(writer == null)
            try {
                throw new IndexWriterException("IndexWriter未初始化！");
            } catch (IndexWriterException e) {
                e.printStackTrace();
                return false;
            }
        document = new Document();

        document.add(new StringField("uri",file.toString(), Store.YES));
        setCrf1Field(file.toString());
        setCrf2Field(file.toString());
       // document.add(new StringField("uri",file, Store.YES));
        writer.deleteDocuments(new Term("uri",file.toString()));
        writer.addDocument(document);
        return  true;


    }
    public  void setCrf1Field(String uri) {
        final int crfNumber = 1;
        partINumber = 1;
        partIINumber = 1;
        String keywordName = "";
        String content = wordDataAcquire.getCrfContent(1,uri);

        /****CRF1_1 *****/
        keywordName = KeyWordName.keywordFile[crfNumber-1][partINumber-1][partIINumber-1];
        Map<String,String> crfFieldMap_1_1 = wordDataAcquire.getPartFieldMap(keywordName,content);
        fieldAdd(crfFieldMap_1_1,crf_field_1_1);

        /****CRF1_2 *****/
        partINumber++;
        partIINumber = 1;
        keywordName = KeyWordName.keywordFile[crfNumber-1][partINumber-1][partIINumber-1];
        Map<String,String> crfFieldMap_1_2 = wordDataAcquire.getPartFieldMap(keywordName,content);
        crfFieldMap_1_2 = crf_field_1_2.finalHandle(crfFieldMap_1_2);
        fieldAdd(crfFieldMap_1_2,crf_field_1_2);

        System.out.print("test");


        /****CRF*******/
        //TODO:找到合适的分词器算法后再将它加进来
        //content = wordDataAcquire.getWholeWord(uri);
        //document.add(new TextField("crf",content,Field.Store.NO));

    }


    public  void setCrf2Field(String uri) {

        final int crfNumber = 2;
        partINumber = 1;
        partIINumber = 1;
        String content;
        String reg = "病灶"+"[1-3]\\d*"+"：";  //正则表达式匹配"病灶1"，"病灶2"，"病灶3"，用于分割文本

        content = getCrf2Content(uri);

        /****CRF2_1 实验室检查部分*****/
        Map<String,String> crfFieldMap_labStudy = getFieldMap(crfNumber,content);
        /****CRF2_1 术前实验室检查额外部分*****/
        Map<String,String> crfFieldMap_extra = getFieldMap(crfNumber,content);
        /****CRF2_1 合并两部分数据*****/
        Map<String,String> crfFieldMap_2_1 = new IdentityHashMap<>();
        crfFieldMap_2_1.putAll(crfFieldMap_labStudy);
        crfFieldMap_2_1.putAll(crfFieldMap_extra);
       // if(!crfFieldMap_2_1.isEmpty())
         //   document.add(new StringField("术前实验室检查","有", Store.NO));
        /****CRF2_1 新建Field放入Document中*****/
        fieldAdd(crfFieldMap_2_1, crf_field_preLabStudy);

        /*****Crf2_2 进入下一个部分*********/
        goNextPart();
        /*****Crf2_2 获取文本内容*********/
        content = getCrf2Content(uri);

        String[] contentsUS = content.split(reg);

        /****CRF2_2 术前US检查前额外部分*****/
        Map<String,String> crfFieldMap_USExtra = getFieldMap(crfNumber,contentsUS[0]);
        /****CRF2_2 术前US检查*****/
        Map<String,String> crfFieldMap_preUS = getFocusFieldMap(uri,crfNumber,"术前US病灶");
        if(!crfFieldMap_preUS.isEmpty())
            document.add(new StringField("术前US检查","有", Store.NO));
        /****CRF2_2 合并两部分数据*****/
        crfFieldMap_preUS.putAll(crfFieldMap_USExtra);
        /****CRF2_1 新建Field放入Document中*****/
        fieldAdd(crfFieldMap_preUS,crf_field_preUS);


        /*****Crf2_3 进入下一个部分MRI*********/
        goNextPart();
        Map<String,String> crfFieldMap_preMRI = getFocusFieldMap(uri,crfNumber,"术前MRI病灶");
        if(!crfFieldMap_preMRI.isEmpty())
            document.add(new StringField("术前MRI检查","有", Store.NO));
        fieldAdd(crfFieldMap_preMRI,crf_field_preMRI);

        /*****Crf2_4 进入下一个部分CT*********/
        goNextPart();
        Map<String,String> crfFieldMap_preCT = getFocusFieldMap(uri,crfNumber,"术前增强CT病灶");
        if(!crfFieldMap_preCT.isEmpty())
            document.add(new StringField("术前CT检查","有", Store.NO));
        fieldAdd(crfFieldMap_preCT,crf_field_preCT);

        /*****Crf2_5 进入下一个部分CEUS,注释同US*********/
        goNextPart();

        content = getCrf2Content(uri);
        String[] contentsCEUS = content.split(reg);
        Map<String,String> crfFieldMap_CEUSExtra = getFieldMap(crfNumber,contentsCEUS[0]);
        Map<String,String> crfFieldMap_preCEUS = getFocusFieldMap(uri,crfNumber,"术前CEUS病灶");

        crfFieldMap_preCEUS.putAll(crfFieldMap_CEUSExtra);
        if(!crfFieldMap_preCEUS.isEmpty())
            document.add(new StringField("术前CEUS检查","有", Store.NO));
        fieldAdd(crfFieldMap_preCEUS,crf_field_preCEUS);

        /*****Crf2_6 进入下一个部分PET-CT,注释同US*********/
        goNextPart();

        content = getCrf2Content(uri);
        String[] contentsPETCT = content.split(reg);
        String contentPETCTExtra = contentsPETCT[0] + contentsPETCT[3]; //因为有前后2部分
        Map<String,String> crfFieldMap_PETCTExtra = getFieldMap(crfNumber,contentPETCTExtra);
        Map<String,String> crfFieldMap_prePETCT = getFocusFieldMap(uri,crfNumber,"术前PET-CT病灶");
        if(!crfFieldMap_prePETCT.isEmpty())
            document.add(new StringField("术前PETCT检查","有", Store.NO));
        crfFieldMap_prePETCT.putAll(crfFieldMap_PETCTExtra);
        fieldAdd(crfFieldMap_prePETCT,crf_field_prePETCT);

        System.out.print("test");

    }



    public void fieldAdd(Map<String,String> crfFieldMap, Crf_Field crf_field){
        List<String> STORE_ATOM = crf_field.getStoreAtom();
        List<String> NORMAL_ATOM = crf_field.getNormalAtom();
        List<String> NORMAL_NO_ATOM = crf_field.getNormalNoAtom();
        List<String> INT_STORE = crf_field.getIntStore();
        List<String> FLOAT_STORE = crf_field.getFLOAT_STORE();
        for(Map.Entry<String, String> entry : crfFieldMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            //TODO:如果没有一个域要设置两种不同格式的情况，考虑将判断改为if，else if的形式，这部分关于正反选也许还可以优化
            //如果含有ALL，那么该list中保存的关键字相当于反选，也就是包含的不属于此类，不包含的属于此类。
            if( (!STORE_ATOM.contains("all") && STORE_ATOM.contains(entry.getKey())) || (STORE_ATOM.contains("all") && !STORE_ATOM.contains(entry.getKey())))
                document.add(new StringField(key,value, Store.YES));
            if( (!NORMAL_ATOM.contains("all") && NORMAL_ATOM.contains(entry.getKey())) || (NORMAL_ATOM.contains("all") && !NORMAL_ATOM.contains(entry.getKey())) )
                document.add(new StringField(key,value, Store.NO));
            if( (!NORMAL_NO_ATOM.contains("all") && NORMAL_NO_ATOM.contains(entry.getKey())) || (NORMAL_NO_ATOM.contains("all") && !NORMAL_NO_ATOM.contains(entry.getKey())))
                document.add(new TextField(key,value, Store.NO));
            if((!INT_STORE.contains("all") && INT_STORE.contains(entry.getKey())) || (INT_STORE.contains("all") && !INT_STORE.contains(entry.getKey()))){
                //TODO:进行表单验证之后，可以考虑去掉对空字符串的验证，可以不需要存储和建立NumericDocValue来实现排序
                if(value == null || value.equals("") )
                    value = 0+ "";
                document.add(new StringField(key,value, Store.YES));
                document.add(new IntPoint(key,Integer.parseInt(value)));
                document.add(new StoredField(key,Integer.parseInt(value)));
                document.add(new NumericDocValuesField(key,Integer.parseInt(value)));

            }
            if((!FLOAT_STORE.contains("all") && FLOAT_STORE.contains(entry.getKey()) )|| (FLOAT_STORE.contains("all") && !FLOAT_STORE.contains(entry.getKey()))){
                //TODO:进行表单验证之后，可以考虑去掉对空字符串的验证
                if(value == null || value.equals("") )
                    value = 0+ "";
                document.add(new StringField(key,value, Store.NO));
                document.add(new FloatPoint(key,Float.parseFloat(value)));
            }
        }
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void createWriter() throws IOException {
        writer = getWriter();
    }
    public void closeWriter() throws IOException {
        writer.close();
    }

    public IndexWriter getWriter() throws IOException {
        directory  = FSDirectory.open(Paths.get(indexDir));
        //Analyzer analyzer = new SmartChineseAnalyzer();
        //Analyzer analyzer = new NLPIRTokenizerAnalyzer("", 1, "", "", false);
        Analyzer analyzer = new NLPIRTokenizerAnalyzer("", 1, "", "/Users/Debbie/bitarmdcrf/src/main/resources/userDict.txt", false);
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        return new IndexWriter(directory,iwc);
    }

    public Map<String,String> getFieldMap(int crfNumber,String content){
        keyWord = KeyWordName.keywordFile[crfNumber-1][partINumber-1][partIINumber-1];
        Map<String,String> crfFieldMap = wordDataAcquire.getPartFieldMap(keyWord,content);
        partIINumber++;   //迭代到下一个待处理部分
        return crfFieldMap;
    }
    public Map<String,String> getElementFieldMap(int crfNumber,String content){
        keyWord = KeyWordName.keywordFile[crfNumber-1][partINumber-1][partIINumber-1];
        Map<String,String> crfFieldMap = wordDataAcquire.getElementFieldMap(keyWord,content);
        partIINumber++;   //迭代到下一个待处理部分
        return crfFieldMap;
    }
    public String getCrf2Content(String uri){
        return wordDataAcquire.getLineContent(CRFLineNumber.Crf2[partINumber-1][0],CRFLineNumber.Crf2[partINumber-1][1],uri);
    }

    public Map<String,String> getFocusFieldMap(String uri,int crfNumber,String focusName){
        String content = getCrf2Content(uri);
        String regMRI = "病灶"+"[1-3]\\d*"+"：";
        String[] contentsMRI = content.split(regMRI);

        /****CRF2_3 术前MRI检查*****/
        Map<String,String> crfFieldMap_Focus1 = getElementFieldMap(crfNumber,contentsMRI[1]);
        Map<String,String> crfFieldMap_Focus2 = getElementFieldMap(crfNumber,contentsMRI[2]);
        Map<String,String> crfFieldMap_Focus3 = getElementFieldMap(crfNumber,contentsMRI[3]);
        /****CRF2_3 合并数据*****/
        Map<String,String> crfFieldMap_Focus = new IdentityHashMap<>();
        if(!crfFieldMap_Focus1.isEmpty())
            crfFieldMap_Focus1.put(focusName+"1","有");
        if(!crfFieldMap_Focus2.isEmpty())
            crfFieldMap_Focus2.put(focusName+"2","有");
        if(!crfFieldMap_Focus3.isEmpty())
            crfFieldMap_Focus3.put(focusName+"3","有");

        crfFieldMap_Focus.putAll(crfFieldMap_Focus1);
        crfFieldMap_Focus.putAll(crfFieldMap_Focus2);
        crfFieldMap_Focus.putAll(crfFieldMap_Focus3);

        return crfFieldMap_Focus;

    }
    public void goNextPart(){
        partINumber++;   //当前表的下一块待处理部分
        partIINumber = 1;   //该部分处理标号初始化1

    }

}

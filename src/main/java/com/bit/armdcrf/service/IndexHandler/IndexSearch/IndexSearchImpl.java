package com.bit.armdcrf.service.IndexHandler.IndexSearch;

import com.bit.armdcrf.dictionary.CodeToValue;
import com.bit.armdcrf.dto.WordData;
import com.bit.armdcrf.service.Interface.IndexSearch;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class IndexSearchImpl implements IndexSearch {
    public final String indexDir = System.getProperty("user.dir") + "/indexFile";
    Map<String, String> codeToValue = new CodeToValue().getCrf_1_1(); //TODO:spring ioc
    IndexSearcher searcher;
    DirectoryReader reader;


    public boolean getSearcher(){
        Directory dir = null;
        try {
            dir = FSDirectory.open(Paths.get(indexDir));
            reader = DirectoryReader.open(dir);
            searcher = new IndexSearcher(reader);
            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }

    }

    public List<WordData> queryPrase(String query){
        if(!getSearcher())
            return null;
        QueryParser parser = new QueryParser("姓名",new StandardAnalyzer());
        try {
            int count = reader.maxDoc();   //获取所有文档数
            Query q = parser.parse(query);
            TopDocs docs = searcher.search(q, count);
            ScoreDoc[] scoreDocs = docs.scoreDocs;
            return getWordDataResult(scoreDocs);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public List<String> queryPraseReturnId(String query){
        if(!getSearcher())
            return null;
        QueryParser parser = new QueryParser("姓名",new StandardAnalyzer());
        List<String> ids = new LinkedList<>();
        try {
            int count = reader.maxDoc();   //获取所有文档数
            Query q = parser.parse(query);
            TopDocs docs = searcher.search(q, count);
            ScoreDoc[] scoreDocs = docs.scoreDocs;

            for (ScoreDoc scoreDoc : scoreDocs) {
                Document document = null;
                document = searcher.doc(scoreDoc.doc);
                ids.add(document.get(codeToValue.get("caseID")));
            }

            return ids;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }



    @Deprecated
    public List<WordData> advancedSearchWord(Map<String, Map<String, String>> termSet) {

        try {

            int count = reader.maxDoc();   //获取所有文档数
            Map<String, String> term = termSet.get("1");

            BooleanQuery.Builder query = new BooleanQuery.Builder();


            int ageMax = 200;
            int ageMin = 0;
            String dateMax = "";
            String dateMin = "";
            for (Map.Entry<String, String> entry : term.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.endsWith("Max")) {
                    if (key.startsWith("age"))
                        ageMax = Integer.parseInt(value);
                    else if (key.startsWith("date"))
                        dateMax = value;
                } else if (key.endsWith("Min")) {
                    if (key.startsWith("age"))
                        ageMin = Integer.parseInt(value);
                    else if (key.startsWith("date"))
                        dateMin = value;
                } else
                    query.add(new TermQuery(new Term(codeToValue.get(key), value)), BooleanClause.Occur.MUST);
            }
            Query queryDate;
            //if(!dateMax.equals("") && !dateMin.equals("")){
            queryDate = TermRangeQuery.newStringRange(codeToValue.get("date"), dateMin, dateMax, true, true);
            // }
            query.add(queryDate, BooleanClause.Occur.MUST);
            Query queryAge = IntPoint.newRangeQuery(codeToValue.get("age"), ageMin, ageMax);
            query.add(queryAge, BooleanClause.Occur.MUST);
            Query multiTermQuery = query.build();


            TopDocs docs = searcher.search(multiTermQuery, count);
            ScoreDoc[] scoreDocs = docs.scoreDocs;
            return getWordDataResult(scoreDocs);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;
    }


    @Override
    public List<WordData> searchWord(String parse) {
        if(!getSearcher())
            return null;
        return queryPrase(parse);
    }

    @Deprecated
    @Override
    public List<WordData> searchWord(Map<String, Map<String, String>> termSet) {

        if(!getSearcher())
            return null;
        return advancedSearchWord(termSet);
    }

    @Override
    public List<String> searchWordId(String parse) {
        if(!getSearcher())
            return null;
        return queryPraseReturnId(parse);
    }

    @Override
    public List<String> searchWordId(Map<String, Map<String, String>> termSet) {
        return null;
    }

//返回检索数据集
    public List<WordData> getWordDataResult(ScoreDoc[] scoreDocs) {
        List<WordData> rs = new LinkedList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document document = null;
            try {
                document = searcher.doc(scoreDoc.doc);
                WordData data = new WordData();
                data.setAge(Integer.parseInt(document.get(codeToValue.get("hospitalID"))));
                data.setCellPhone(document.get(codeToValue.get("cellphone")));
                data.setContacts(document.get(codeToValue.get("contact")));

                data.setDate(document.get(codeToValue.get("date")));
                data.setHomePhone(document.get(codeToValue.get("homephone")));
                data.setHospitalID(document.get(codeToValue.get("hospitalID")));
                data.setPatientID(document.get(codeToValue.get("caseID")));
                data.setPatientName(document.get(codeToValue.get("name")));
                data.setSex(document.get(codeToValue.get("sex")));
                data.setUri(document.get("uri"));
                data.setWorkPhone(document.get(codeToValue.get("workphone")));
                rs.add(data);

//                System.out.println(document.get(codeToValue.get("hospitalID")));
//                System.out.println(document.get(codeToValue.get("age")));
//                System.out.println(document.get(codeToValue.get("name")));
//                System.out.println(document.get(codeToValue.get("date")));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return rs;
    }
//返回检索结果病人id
    public WordData getListIdResult(ScoreDoc[] scoreDocs) {
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document document = null;
            try {
                document = searcher.doc(scoreDoc.doc);
                System.out.println(document.get(codeToValue.get("patientID")));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    @Override
    public List<WordData> getAll(){
        List<WordData> rs = new LinkedList<>();
        if(!getSearcher())
            return null;
        int count = reader.maxDoc();//所有文档数
        try {
            for(int i = 0; i < count; i++){
                Document document = searcher.doc(i);
                WordData data = new WordData();
                data.setAge(Integer.parseInt(document.get(codeToValue.get("hospitalID"))));
                data.setCellPhone(document.get(codeToValue.get("cellphone")));
                data.setContacts(document.get(codeToValue.get("contact")));

                data.setDate(document.get(codeToValue.get("date")));
                data.setHomePhone(document.get(codeToValue.get("homephone")));
                data.setHospitalID(document.get(codeToValue.get("hospitalID")));
                data.setPatientID(document.get(codeToValue.get("caseID")));
                data.setPatientName(document.get(codeToValue.get("name")));
                data.setSex(document.get(codeToValue.get("sex")));
                data.setUri(document.get("uri"));
                data.setWorkPhone(document.get(codeToValue.get("workphone")));
                rs.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs;

    }

    @Override
    public List<String> getAllId(){

        List<String> ids = new LinkedList<>();
        if(!getSearcher())
            return ids;
        int count = reader.maxDoc();//所有文档数
        try {
            for(int i = 0; i < count; i++){
                Document document = searcher.doc(i);
                ids.add(document.get(codeToValue.get("caseID")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;

    }

}

package com.bit.armdcrf;

import com.bit.armdcrf.dictionary.CodeToValue;
import nlpir.lucene.cn.ictclas.NLPIRTokenizerAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public class IndexSearchTest {
    public final String indexDir = System.getProperty("user.dir") +"/indexFile";

    @Test
    public void synonymTermSearch() throws IOException, ParseException {

        Map<String,String> codeToValue = new CodeToValue().getCrf_1_1();

        List<String> result = new ArrayList<>();
        IndexSearcher indexSearcher = null;
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir)));
        indexSearcher = new IndexSearcher(indexReader);
        Analyzer analyzer = new NLPIRTokenizerAnalyzer("", 1, "", "/Users/Debbie/bitarmdcrf/src/main/resources/userDict.txt", false);

        QueryParser queryParser = new QueryParser("相关病史", analyzer);
        Query query = queryParser.parse("乙肝");
        TopDocs td = indexSearcher.search(query, 10);
        for (int i = 0; i < td.totalHits; i++) {
            Document document = indexSearcher.doc(td.scoreDocs[i].doc);
            System.out.println(document.get(codeToValue.get("hospitalID")));
            System.out.println(document.get(codeToValue.get("age")));
            System.out.println(document.get(codeToValue.get("name")));
            System.out.println(document.get(codeToValue.get("date")));
        }

    }
}

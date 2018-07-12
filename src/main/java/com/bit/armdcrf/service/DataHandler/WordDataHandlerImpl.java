package com.bit.armdcrf.service.DataHandler;

import com.bit.armdcrf.dictionary.CRFLineNumber;
import com.bit.armdcrf.dictionary.KeyWordName;
import com.bit.armdcrf.dto.SearchData;
import com.bit.armdcrf.dto.WordData;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.other.CrfHandler;
import com.bit.armdcrf.service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


/**
 * @author Debbie Qiu
 */
@Component
public class WordDataHandlerImpl implements WordDataHandler {

    @Autowired
    WordDataAcquire wordDataAcquire;
    @Autowired
    IndexWord indexWord;
    @Autowired
    IndexSearch indexSearch;
    @Autowired
    CrfWordResolve crfWordResolve;



    public boolean save(Map<String, String> CRF,String crf_part,String uris){

        return false;

    }

    @Override
    public boolean add(String uri){



        try {
            URI url = new URI(uri);
            Files.walkFileTree(Paths.get(url.getSchemeSpecificPart()), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                    System.out.println("正在访问：" + dir + "目录");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(!file.getFileName().toString().endsWith(".docx"))
                        return FileVisitResult.CONTINUE;
                    String fileName = file.getFileName().toString();
                    System.out.println("\t正在访问" + fileName + "文件");
                    //新建一个indexWriter对象
                    indexWord.createWriter();
                    if (fileName.endsWith(".docx") && fileName.startsWith("CRF")) {
                       //TODO:对找到的docx文件进行索引
                        indexWord.fileIndexCreate(file);
                    }
                    //关闭indexWriter对象
                    indexWord.closeWriter();
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<WordData> search(String search) {
        if(search.equals(""))
            return indexSearch.getAll();
        else
            return indexSearch.searchWord(search);
    }

    @Override
    public List<WordData> advancedSearch(SearchData searchData) {

        return indexSearch.searchWord(searchData.toQueryEL());

    }

    @Override
    public List<String> searchWordId(SearchData searchData) {


        return indexSearch.searchWordId(searchData.toQueryEL());
    }
    @Override
    public List<String> searchWordIdByExpress(String data) {
        if(data.equals(""))
            return indexSearch.getAllId();
        else
            return indexSearch.searchWordId(data);
    }



    @Override
    public Crf viewWord(String uri, String part) {
        String[] no = part.split("-");
        int part1 = Integer.parseInt(no[0]);
        int part2 = Integer.parseInt(no[1]);
        int part3 = Integer.parseInt(no[2]);  //这个参数是因为有的部分是由2个表部分结合而成，例如术前实验室检查是有labstudy和prestudy结合在一起
        String content = wordDataAcquire.getLineContent(CRFLineNumber.Crf2[part2-1][0],CRFLineNumber.Crf2[part2-1][1],uri);
        Map<String,String> values = new HashMap<>();
        for(int i=0;i<part3;i++) {
            String keyWord = KeyWordName.keywordFile[part1 - 1][part2 - 1][i];
            values.putAll(wordDataAcquire.getPartFieldMap(keyWord,content));
        }


        return CrfHandler.mapToCrf(CrfHandler.getCrfModel(part),values,CrfHandler.getCrfDict(part));
    }

    @Override
    public void updateWord(Crf crf, String uri) {
        Date date=new Date();
        long s=date.getTime();
        String sUri = uri + s +".docx";
        crfWordResolve.TableToWord(uri,sUri,crf);

    }

}

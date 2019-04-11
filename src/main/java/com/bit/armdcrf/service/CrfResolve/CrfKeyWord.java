package com.bit.armdcrf.service.CrfResolve;


import com.bit.armdcrf.entity.Keyword;
import com.bit.armdcrf.entity.enums.KeywordTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Debbie Qiu
 */
@Component
public class CrfKeyWord {

    private static Logger logger = LogManager.getLogger(CrfWordResolveImpl.class);

    /**
     * 提取存储在文本文件中的关键字封装进List中.
     * @param fileName
     */
    public static List<Keyword> getKeyWords(String fileName) {
        logger.info("开始获取对应所处理文档部分的关键字集"+ fileName + "。");
        //URL url  = CrfWordResolveImpl.class.getClassLoader().getResource("/keywordFile/" +keywordPath);
        fileName = System.getProperty("user.dir")+"/keywordFile/" +fileName;

        List<Keyword> keywords = new ArrayList<Keyword>();
        String keyword = "";
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(new File(fileName)));
            String str = in.readLine();   //获取分割关键字
            while (str != null) {
                keyword = str.trim();
                if (keyword.contains("@")) {
                    String[] results = keyword.split("@");
                    keywords.add(new Keyword(results[0], KeywordTypeEnum.KEYWORD));
                    keywords.add(new Keyword(results[1], KeywordTypeEnum.UNIT));
                } else if (keyword.startsWith("&")) {
                    keyword = keyword.substring(1);
                    keywords.add(new Keyword(keyword, KeywordTypeEnum.CHECKBOX));
                } else
                    keywords.add(new Keyword(keyword, KeywordTypeEnum.KEYWORD));
                str = in.readLine();
            }
        }
        // if the file is not found, the program displays an error message and exits
        catch (IOException e) {
            System.out.println("The file " + fileName + " was not found.");
            System.exit(0);
        }
        return keywords;
    }

}

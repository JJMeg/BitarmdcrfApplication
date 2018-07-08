package com.bit.armdcrf.entity;

import com.bit.armdcrf.entity.enums.KeywordTypeEnum;


public class Keyword {
    private String content;
    private KeywordTypeEnum keywordType;


    public Keyword(String content, KeywordTypeEnum keywordType) {
        this.content = content;
        this.keywordType = keywordType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public KeywordTypeEnum getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(KeywordTypeEnum keywordType) {
        this.keywordType = keywordType;
    }
}

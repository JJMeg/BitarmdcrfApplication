package com.bit.armdcrf.entity.enums;

public enum KeywordTypeEnum {

    KEYWORD(0,"关键字"),
    UNIT(1,"单位"),
    CHECKBOX(2,"选项卡");



    private int index;   //0关键字 1单位 2选项卡

    private String content;
    private KeywordTypeEnum(int index, String content) {
        this.content = content;
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }





}

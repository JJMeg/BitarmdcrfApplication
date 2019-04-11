package com.bit.armdcrf.entity.enums;

/**
 * @author Debbie Qiu
 */
public enum ExamStage {

    STAGE_PRE(0,"术前"),
    STAGE_INTRA(1,"术中"),
    STAGE_IMMED(2,"术后即时"),
    STAGE_7DAY(3,"术后七天内"),
    STAGE_1MON(4,"术后一个月"),
    STAGE_3MON(5,"术后三个月"),
    STAGE_6MON(6,"术后六个月"),
    STAGE_9MON(7,"术后九个月"),
    STAGE_12MON(8,"术后十二个月"),
    STAGE_18MON(9,"术后十八个月"),
    STAGE_24MON(10,"术后二十四个月"),
    STAGE_30MON(11,"术后三十个月"),
    STAGE_36MON(12,"术后三十六个月"),;


    private int index;
    private String stage;

    ExamStage(int index, String stage) {
        this.index = index;
        this.stage = stage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    //根据对应的文档部位生成的编号查找获取对应的关键字文件名称
    public static String stageOf(int index){
        for(ExamStage value: ExamStage.values()){
            if(value.getIndex() == index){
                return value.stage;
            }
        }
        return null;

    }
}

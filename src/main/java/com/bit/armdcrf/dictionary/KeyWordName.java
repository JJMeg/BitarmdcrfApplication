package com.bit.armdcrf.dictionary;

/**
 * 该字典表表用于获取关键字文本文件的名字
 * @author Debbie Qiu
 */
public class KeyWordName {
    public static final String[][][] keywordFile = {
            {{"crf1_part1.txt"},{"crf1_part2.txt"}},      //crf1
            {{"labStudy.txt","preLab.txt"},{"preUSExtra.txt","preUS.txt","preUS.txt","preUS.txt"},  //CRF2
                    {"preMRI.txt","preMRI.txt","preMRI.txt"},{"preCT.txt","preCT.txt","preCT.txt"},
                    {"preCEUSExtra.txt","preCEUS.txt","preCEUS.txt","preCEUS.txt"},
                    {"prePETCTExtra.txt","prePETCT.txt","prePETCT.txt","prePETCT.txt"}},
                    {}, //CRF3
    };
    public static String getPath(int crfNo,int partNo){


        if(crfNo == 2 && partNo == 1)
            return "lab_study.txt";
        else if(crfNo == 2 && (partNo == 4 || partNo == 5 || partNo == 6 ))
            return "preUS.txt";
        else if(crfNo == 2 && (partNo == 7 || partNo == 8 || partNo == 9 ))
            return "preMRI.txt";
        else if(crfNo == 2 && (partNo == 10 || partNo == 11 || partNo ==12 ))
            return "preCT.txt";
        else
            return "crf" + crfNo + "_part"+ partNo +".txt";
    }
}

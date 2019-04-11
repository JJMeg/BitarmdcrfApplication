package com.bit.armdcrf.dictionary;


/**
 * @author Debbie Qiu
 */
public class CRFLineNumber {
    public final static int S_CRF1_1 = 38;
    public final static int E_CRF1_1 = 45;
    public final static int S_CRF1_2 = 46;
    public final static int E_CRF1_2 = 65;
    /**********/
    public final static int S_CRF2_1 = 67;
    public final static int E_CRF2_1 = 85;
    /**********/
    public final static int S_CRF2_2 = 83;
    public final static int E_CRF2_2 = 86;
    public final static int S_CRF2_3 = 86;
    public final static int E_CRF2_3 = 89;
    public final static int S_CRF2_4 = 89;
    public final static int E_CRF2_4 = 100;
    public final static int S_CRF2_5 = 101;
    public final static int E_CRF2_5 = 112;
    /**********/
    public final static int S_CRF2_6 = 113;
    public final static int E_CRF2_6 = 124;

    public final static int S_CRF2_7 = 125;
    public final static int E_CRF2_7 = 134;
    public final static int S_CRF2_8 = 134;
    public final static int E_CRF2_8 = 143;
    public final static int S_CRF2_9 = 143;
    public final static int E_CRF2_9 = 152;
    public final static int S_CRF2_10 = 153;
    public final static int E_CRF2_10 = 162;
    public final static int S_CRF2_11 = 163;
    public final static int E_CRF2_11 = 171;
    public final static int S_CRF2_12 = 172;
    public final static int E_CRF2_12 = 180;

    public static final int[][] crf = {{38,65},{65,85}};

    public static final int[][][] crfPart = {{{67,85}},{{67,85},{85,124},{125,152},{153,180},{180,200},{200,209}}};  //用于获取返回给前端显示的部分

    public static final int[][] Crf2 = {{65,85},{85,124},{125,152},{153,180},{180,200},{200,209}};


    public static int getCrfStart(int crf, int part){
        String no = ""+crf+part;

        if(no.equals("11"))
            return S_CRF1_1;
        else if(no.equals("12"))
            return S_CRF1_2;
        else if(no.equals("21"))
            return S_CRF2_1;
        else if(no.equals("22"))
            return S_CRF2_2;
        else if(no.equals("23"))
            return S_CRF2_3;
        else if(no.equals("24"))
            return S_CRF2_4;
        else if(no.equals("25"))
            return S_CRF2_5;
        else if(no.equals("26"))
            return S_CRF2_6;
        else if(no.equals("27"))
            return S_CRF2_7;
        else if(no.equals("28"))
            return S_CRF2_8;
        else if(no.equals("29"))
            return S_CRF2_9;
        else if(no.equals("210"))
            return S_CRF2_10;
        else if(no.equals("211"))
            return S_CRF2_11;
        else if(no.equals("212"))
            return S_CRF2_12;
        else
            return 0; //TODO:其他表格
    }
    public static int getCrfEnd(int crf,int part){
        String no = ""+crf+part;
        if(no.equals("11"))
            return E_CRF1_1;
        else if(no.equals("12"))
            return  E_CRF1_2;
        else if(no.equals("21"))
            return E_CRF2_1;
        else if(no.equals("22"))
            return E_CRF2_2;
        else if(no.equals("23"))
            return E_CRF2_3;
        else if(no.equals("24"))
            return E_CRF2_4;
        else if(no.equals("25"))
            return E_CRF2_5;
        else if(no.equals("26"))
            return E_CRF2_6;
        else if(no.equals("27"))
            return E_CRF2_7;
        else if(no.equals("28"))
            return E_CRF2_8;
        else if(no.equals("29"))
            return E_CRF2_9;
        else if(no.equals("210"))
            return E_CRF2_10;
        else if(no.equals("211"))
            return E_CRF2_11;
        else if(no.equals("212"))
            return E_CRF2_12;
        else
            return 0; //TODO:其他表格
    }

}

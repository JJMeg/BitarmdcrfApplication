package com.bit.armdcrf.entity.Crf;

import com.alibaba.fastjson.annotation.JSONField;
import com.bit.armdcrf.dictionary.CRFLineNumber;
import com.bit.armdcrf.dictionary.CodeToValue;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
public class Crf2_1 implements Crf{

   // public static int startLine = CRFLineNumber.Crf2[0][1];
   // public static int endLine = CRFLineNumber.Crf2[0][2];

    private String labStudy;
    private String  AFP;
    private String CEA;
    private String  CA199;
    private String CA125;

    private String WBCCount;
    private String HGB;
    private String PLT;

    private String ALT;
    private String AST;
    private String TB;
    private String DB;
    private String TP;
    private String Alb;
    private String GGT;
    private String TG;
    private String ALP;
    private String Glu;

    private String hb;
    private String FOBT;
    private String PT;
    private String PTA;

    private String SFT;
    private String ChildPugh;
    private String ZPS;
    private String recorder;

    public String getLabStudy() {
        return labStudy;
    }

    public void setLabStudy(String labStudy) {
        this.labStudy = labStudy;
    }

    @JSONField(name = "AFP")
    public String getAFP() {
        return AFP;
    }


    public void setAFP(String AFP) {
        this.AFP = AFP;
    }
    @JSONField(name = "CEA")
    public String getCEA() {
        return CEA;
    }

    public void setCEA(String CEA) {
        this.CEA = CEA;
    }

    @JSONField(name = "CA199")
    public String getCA199() {
        return CA199;
    }

    public void setCA199(String CA199) {
        this.CA199 = CA199;
    }

    @JSONField(name = "CA125")
    public String getCA125() {
        return CA125;
    }

    public void setCA125(String CA125) {
        this.CA125 = CA125;
    }

    @JSONField(name = "WBCCount")
    public String getWBCCount() {
        return WBCCount;
    }

    public void setWBCCount(String WBCCount) {
        this.WBCCount = WBCCount;
    }


    @JSONField(name = "HGB")
    public String getHGB() {
        return HGB;
    }

    public void setHGB(String HGB) {
        this.HGB = HGB;
    }

    @JSONField(name = "PLT")
    public String getPLT() {
        return PLT;
    }

    public void setPLT(String PLT) {
        this.PLT = PLT;
    }

    @JSONField(name = "ALT")
    public String getALT() {
        return ALT;
    }

    public void setALT(String ALT) {
        this.ALT = ALT;
    }

    @JSONField(name = "AST")
    public String getAST() {
        return AST;
    }

    public void setAST(String AST) {
        this.AST = AST;
    }

    @JSONField(name = "TB")
    public String getTB() {
        return TB;
    }

    public void setTB(String TB) {
        this.TB = TB;
    }

    @JSONField(name = "DB")
    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    @JSONField(name = "TP")
    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    @JSONField(name = "Alb")
    public String getAlb() {
        return Alb;
    }

    public void setAlb(String alb) {
        Alb = alb;
    }

    @JSONField(name = "GGT")
    public String getGGT() {
        return GGT;
    }

    public void setGGT(String GGT) {
        this.GGT = GGT;
    }

    @JSONField(name = "TG")
    public String getTG() {
        return TG;
    }

    public void setTG(String TG) {
        this.TG = TG;
    }

    @JSONField(name = "ALP")
    public String getALP() {
        return ALP;
    }

    public void setALP(String ALP) {
        this.ALP = ALP;
    }

    @JSONField(name = "Glu")
    public String getGlu() {
        return Glu;
    }

    public void setGlu(String glu) {
        Glu = glu;
    }


    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    @JSONField(name = "FOBT")
    public String getFOBT() {
        return FOBT;
    }

    public void setFOBT(String FOBT) {
        this.FOBT = FOBT;
    }

    @JSONField(name = "PT")
    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }

    @JSONField(name = "PTA")
    public String getPTA() {
        return PTA;
    }

    public void setPTA(String PTA) {
        this.PTA = PTA;
    }

    @JSONField(name = "SFT")
    public String getSFT() {
        return SFT;
    }

    public void setSFT(String SFT) {
        this.SFT = SFT;
    }

    @JSONField(name = "ChildPugh")
    public String getChildPugh() {
        return ChildPugh;
    }

    public void setChildPugh(String childPugh) {
        ChildPugh = childPugh;
    }

    @JSONField(name = "ZPS")
    public String getZPS() {
        return ZPS;
    }

    public void setZPS(String ZPS) {
        this.ZPS = ZPS;
    }


    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }



    public int getStartLine() {
        return CRFLineNumber.Crf2[0][0];

    }
    public int getEndLine(){
        return CRFLineNumber.Crf2[0][1];
    }

    public Map<String,String> getDict(){
        CodeToValue codeToValue = new CodeToValue();
        Map<String,String> value = codeToValue.getCrf_2_1();
        value.putAll(codeToValue.getLabStudy());

        return value;
    }
//    public String toWord(){
//        CodeToValue codeToValue = new CodeToValue();
//        Map<String,String> value = codeToValue.getCrf_2_1();
//        value.putAll(codeToValue.getLabStudy());
//
//
//    }



}

package com.bit.armdcrf.dictionary;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Component
public class CodeToValue {
    private Map<String,String> labStudy = new LinkedHashMap<>();


    private Map<String,String> crf_1_1 = new LinkedHashMap<>();
    private Map<String,String> crf_1_2 = new LinkedHashMap<>();
    private Map<String,String> crf_2_1 = new LinkedHashMap<>();
    //private Map<String,String> crf_2_2 = new LinkedHashMap<>();
    private Map<String,String> crf_2_3 = new LinkedHashMap<>(); //术前US表以外的其他内容

    private Map<String,String> preFocus = new LinkedHashMap<>();

    private Map<String,String> preUS = new LinkedHashMap<>();
    private Map<String,String> preMRI = new LinkedHashMap<>();
    private Map<String,String> preCT = new LinkedHashMap<>();
    private Map<String,String> preCEUS = new LinkedHashMap<>();
    private Map<String,String> prePETCT = new LinkedHashMap<>();

 /* private String hospitalID= "医院（分中心编号）";
    private String caseID = "病例编号";
    private String date = "纳入日期";
    private String name = "姓名";
    private String sex = "性别";
    private String age = "年龄";
    private String contact = "联系人";
    private String homephone = "家庭电话";
    private String cellphone = "手机";
    private String workphone = "单位电话";
    */



  public CodeToValue(){
      crf_1_1.put("hospitalID","医院（分中心编号）");
      crf_1_1.put("caseID","病例编号");
      crf_1_1.put("date","纳入日期");
      crf_1_1.put("name","姓名");
      crf_1_1.put("sex","性别");
      crf_1_1.put("age","年龄");
      crf_1_1.put("contact","联系人");
      crf_1_1.put("homephone","家庭电话");
      crf_1_1.put("cellphone","手机");
      crf_1_1.put("workphone","单位电话");

      /**********CRF_1_2****************/
      crf_1_2.put("history","相关病史");
      crf_1_2.put("hepB","乙型肝炎病史");
      crf_1_2.put("hepC","丙型肝炎病史");
      crf_1_2.put("drunk","酗酒病史");
      crf_1_2.put("chemical","黄曲霉素等化学物接触史");
      crf_1_2.put("medical","药物治疗");
      crf_1_2.put("medicineName","药物名称");
      crf_1_2.put("cureTime","治疗时间");
      crf_1_2.put("operation","手术切除");
      crf_1_2.put("operation_number","切除");
      crf_1_2.put("focus_numer","共切除病灶数");
      crf_1_2.put("mini_invasive","微创治疗");
      crf_1_2.put("treat_method","治疗方式");
      crf_1_2.put("treat_focus","治疗病灶数");
      crf_1_2.put("liver_trans","肝移植");
      crf_1_2.put("liver_trans_result","肝移植结果");
      crf_1_2.put("symptom","HCC相关临床症状");
      crf_1_2.put("sign","HCC体征");
      crf_1_2.put("compl","合并症");
      crf_1_2.put("neopathy","并发症");





      /***********LabStudy***************/
      labStudy.put("labStudy","术前实验室检查");
      labStudy.put("preLabStudy","术前实验室检查");
      labStudy.put("TMDetection","肿瘤标记物检测");
      labStudy.put("AFP","AFP");
      labStudy.put("CEA","CEA");
      labStudy.put("CA199","CA19-9");
      labStudy.put("CA125","CA125");

      labStudy.put("bloodRT","血常规检测");
      labStudy.put("WBCCount","白细胞计数");
      labStudy.put("HGB","血红蛋白");
      labStudy.put("PLT","血血小板");

      labStudy.put("bloodBC","血生化检查");
      labStudy.put("ALT","ALT");
      labStudy.put("AST","AST");
      labStudy.put("TB","TB");
      labStudy.put("DB","DB");
      labStudy.put("TP","TP");
      labStudy.put("Alb","Alb");
      labStudy.put("GGT","GGT");
      labStudy.put("TG","TG");
      labStudy.put("ALP","ALP");
      labStudy.put("Glu","Glu");

      labStudy.put("urineRT","尿常规检查");
      labStudy.put("hb","Hb尿");

      labStudy.put("otherTest","其他检查");
      labStudy.put("FOBT","大便潜血试验");

      labStudy.put("CFDetection","凝血功能检测");
      labStudy.put("PT","凝血酶原时间");
      labStudy.put("PTA","凝血酶原活动度");

      labStudy.put("SFT","血清四项检测");


      /**********CRF_2_1****************/

      crf_2_1.put("ChildPugh","Child-Pugh肝功能分级");
      crf_2_1.put("ZPS","ZPS评分");
      crf_2_1.put("recorder","记录者签名");

      /**********CRF_2_3****************/
      crf_2_3.put("preUS","术前US检查");
      crf_2_3.put("liverBG","肝脏背景");

      /**********preUS****************/
      preUS.put("preUSNo","术前US检查病灶编号");
      preUS.put("FUSLocation","病灶位置");
      preUS.put("FUSSize","大小");
      preUS.put("FUSLong","长");
      preUS.put("FUSWidth","宽");
      preUS.put("FUSDeep","深");
      preUS.put("FUSShape","外形");
      preUS.put("FUSEcho","内部回声");

      //TODO:剩下的US检查表内容


      /*********preFocus***************/
      preFocus.put("FCTSize","大小");
      preFocus.put("FCTLong","长");
      preFocus.put("FCTWidth","宽");
      preFocus.put("FCTDeep","深");
      /**********preMRI****************/


      /**********preCT****************/

      /**********preCEUS****************/

      /**********prePETCT****************/


      /******/

  }

    public Map<String, String> getPreFocus() { return preFocus; }

    public Map<String, String> getCrf_1_1() {
        return crf_1_1;
    }

    public Map<String,String> getCrf_1_2(){
      return crf_1_2;
    }

    public Map<String, String> getLabStudy() {
        return labStudy;
    }

    public Map<String, String> getPreUS() {
        return preUS;
    }

    public Map<String, String> getPreMRI() { return preMRI; }

    public Map<String, String> getPreCEUS() { return preCEUS; }

    public Map<String, String> getPrePETCT() { return prePETCT; }

    public Map<String, String> getPreCT() { return preCT; }

    public Map<String, String> getCrf_2_1() { return crf_2_1; }
}

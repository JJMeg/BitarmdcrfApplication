package com.bit.armdcrf.entity.Crf;

import com.bit.armdcrf.dictionary.CodeToValue;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *  对应CRF1表格中的从相关病史开始的部分，与病人基本信息分开；
 *  针对CheckBox类型，有两种保存方式，Map<String,Integer>保存选项为是和否的选项卡内容，key保存选项标题，value0代表否，1代表是；
 *  Map<String,Map<String，Integer>> 外层key保存选项卡内容，内层key保留选项卡内容，内层value0代表选中，1代表未选中；
 *  所有其他项，会将将填写的文字放入内层String中作为新生成的选项名。
 *
 */
public class Crf1_2 {
    //TODO:表格部分实体化
    final private String tableName = "相关病史";
    /*key是选项标题，value0代表未选中，1代表选中*/
    private Map<String,Integer> hepB;   //乙肝
    private Map<String,Integer> hepC;   //丙肝
    private Map<String,Integer> drunk;  //酗酒
    private Map<String,Integer> chemical;    //黄曲霉素等化学物接触史
    private Map<String,Integer> medicine;    //药物治疗史
    private String medicineName;  //药物名称
    private int cureTime;  //治疗时间(年）
    private Map<String,Integer> operation; //手术切除
    private int operation_number; //切除次数
    private int focus_numer;  //切除病灶数
    private Map<String,Integer> mini_invasive; //微创治疗
    private Map<String,Map<String,Integer>> treat_method;//治疗方式
    private int treat_focus; //治疗病灶数
    private Map<String,Integer> liver_trans;//肝移植
    private Map<String,Map<String,Integer>> liver_trans_result; //肝移植结果
    private Map<String,Map<String,Integer>> symptom;//临床症状
    private Map<String,Map<String,Integer>> sign;//体征
    private Map<String,Map<String,Integer>> compl;//合并症
    private Map<String,Map<String,Integer>> neopathy;//并发症


    public String getTableName() {
        return tableName;
    }

    public Map<String, Integer> getHepB() {
        return hepB;
    }

    public void setHepB(Map<String, Integer> hepB) {
        this.hepB = hepB;
    }

    public Map<String, Integer> getHepC() {
        return hepC;
    }

    public void setHepC(Map<String, Integer> hepC) {
        this.hepC = hepC;
    }

    public Map<String, Integer> getDrunk() {
        return drunk;
    }

    public void setDrunk(Map<String, Integer> drunk) {
        this.drunk = drunk;
    }

    public Map<String, Integer> getChemical() {
        return chemical;
    }

    public void setChemical(Map<String, Integer> chemical) {
        this.chemical = chemical;
    }

    public Map<String, Integer> getMedicine() {
        return medicine;
    }

    public void setMedicine(Map<String, Integer> medicine) {
        this.medicine = medicine;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getCureTime() {
        return cureTime;
    }

    public void setCureTime(int cureTime) {
        this.cureTime = cureTime;
    }

    public Map<String, Integer> getOperation() {
        return operation;
    }

    public void setOperation(Map<String, Integer> operation) {
        this.operation = operation;
    }

    public int getOperation_number() {
        return operation_number;
    }

    public void setOperation_number(int operation_number) {
        this.operation_number = operation_number;
    }

    public int getFocus_numer() {
        return focus_numer;
    }

    public void setFocus_numer(int focus_numer) {
        this.focus_numer = focus_numer;
    }

    public Map<String, Integer> getMini_invasive() {
        return mini_invasive;
    }

    public void setMini_invasive(Map<String, Integer> mini_invasive) {
        this.mini_invasive = mini_invasive;
    }

    public Map<String, Map<String, Integer>> getTreat_method() {
        return treat_method;
    }

    public void setTreat_method(Map<String, Map<String, Integer>> treat_method) {
        this.treat_method = treat_method;
    }

    public int getTreat_focus() {
        return treat_focus;
    }

    public void setTreat_focus(int treat_focus) {
        this.treat_focus = treat_focus;
    }

    public Map<String, Integer> getLiver_trans() {
        return liver_trans;
    }

    public void setLiver_trans(Map<String, Integer> liver_trans) {
        this.liver_trans = liver_trans;
    }

    public Map<String, Map<String, Integer>> getLiver_trans_result() {
        return liver_trans_result;
    }

    public void setLiver_trans_result(Map<String, Map<String, Integer>> liver_trans_result) {
        this.liver_trans_result = liver_trans_result;
    }

    public Map<String, Map<String, Integer>> getSymptom() {
        return symptom;
    }

    public void setSymptom(Map<String, Map<String, Integer>> symptom) {
        this.symptom = symptom;
    }

    public Map<String, Map<String, Integer>> getSign() {
        return sign;
    }

    public void setSign(Map<String, Map<String, Integer>> sign) {
        this.sign = sign;
    }

    public Map<String, Map<String, Integer>> getCompl() {
        return compl;
    }

    public void setCompl(Map<String, Map<String, Integer>> compl) {
        this.compl = compl;
    }

    public Map<String, Map<String, Integer>> getNeopathy() {
        return neopathy;
    }

    public void setNeopathy(Map<String, Map<String, Integer>> neopathy) {
        this.neopathy = neopathy;
    }





    @Override
    public String toString() {
        return "Crf1_2{" +
                "tableName='" + tableName + '\'' +
                ", hepB=" + hepB +
                ", hepC=" + hepC +
                ", drunk=" + drunk +
                ", chemical=" + chemical +
                ", medicine=" + medicine +
                ", medicineName='" + medicineName + '\'' +
                ", cureTime=" + cureTime +
                ", operation=" + operation +
                ", operation_number=" + operation_number +
                ", focus_numer=" + focus_numer +
                ", mini_invasive=" + mini_invasive +
                ", treat_method=" + treat_method +
                ", treat_focus=" + treat_focus +
                ", liver_trans=" + liver_trans +
                ", liver_trans_result=" + liver_trans_result +
                ", symptom=" + symptom +
                ", sign=" + sign +
                ", compl=" + compl +
                ", neopathy=" + neopathy +
                '}';
    }
}

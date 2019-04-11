package com.bit.armdcrf.entity.Crf;

import com.bit.armdcrf.entity.Unit;

import java.util.Map;

/**
 * @author Debbie Qiu
 */
@Deprecated
public class Crf1_3 {

    private Map<String,Unit> tumor_marker; //肿瘤标记物
    private Map<String,Unit> routine_blood; //血常规检测
    private Map<String,Unit> blood_biochemical; //血生化检查
    private Map<String,Unit> routine_urine; //尿常规检查
    private Map<String,Map<String,Integer>> fob;//大便潜血试验
    private Map<String,Unit> coagulation;//凝血功能检测
    private Map<String,Map<String,Integer>> serum;//血清四项检测
    private Map<String,Map<String,Integer>> child_pugh;//Child-Pugh肝功能分级
    private Map<String,Map<String,Integer>> zps;//ZPS评分
    private String recorder;//记录者签名

    public Map<String, Unit> getTumor_marker() {
        return tumor_marker;
    }

    public void setTumor_marker(Map<String, Unit> tumor_marker) {
        this.tumor_marker = tumor_marker;
    }

    public Map<String, Unit> getRoutine_blood() {
        return routine_blood;
    }

    public void setRoutine_blood(Map<String, Unit> routine_blood) {
        this.routine_blood = routine_blood;
    }

    public Map<String, Unit> getBlood_biochemical() {
        return blood_biochemical;
    }

    public void setBlood_biochemical(Map<String, Unit> blood_biochemical) {
        this.blood_biochemical = blood_biochemical;
    }

    public Map<String, Unit> getRoutine_urine() {
        return routine_urine;
    }

    public void setRoutine_urine(Map<String, Unit> routine_urine) {
        this.routine_urine = routine_urine;
    }

    public Map<String, Map<String, Integer>> getFob() {
        return fob;
    }

    public void setFob(Map<String, Map<String, Integer>> fob) {
        this.fob = fob;
    }

    public Map<String, Unit> getCoagulation() {
        return coagulation;
    }

    public void setCoagulation(Map<String, Unit> coagulation) {
        this.coagulation = coagulation;
    }

    public Map<String, Map<String, Integer>> getSerum() {
        return serum;
    }

    public void setSerum(Map<String, Map<String, Integer>> serum) {
        this.serum = serum;
    }

    public Map<String, Map<String, Integer>> getChild_pugh() {
        return child_pugh;
    }

    public void setChild_pugh(Map<String, Map<String, Integer>> child_pugh) {
        this.child_pugh = child_pugh;
    }

    public Map<String, Map<String, Integer>> getZps() {
        return zps;
    }

    public void setZps(Map<String, Map<String, Integer>> zps) {
        this.zps = zps;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }
}

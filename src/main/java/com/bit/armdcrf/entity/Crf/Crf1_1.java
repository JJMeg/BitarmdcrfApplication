package com.bit.armdcrf.entity.Crf;

import com.bit.armdcrf.entity.Unit;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author Debbie Qiu
 */
public class Crf1_1 {
    private String hospitalID;
    private String caseID; //病例编号
    private String date;  //纳入日期
    private String name; //病人姓名
    private String sex;
    private Unit age;
    private String contact; //联系人
    private String homephone;
    private String cellphone;
    private String workphone;

    public Crf1_1() {
    }

    public Crf1_1(List<String> value) {
        this.hospitalID = value.get(0);
        this.caseID = value.get(1);
        this.date = value.get(2);
        this.name = value.get(3);
        this.sex = value.get(4);
        //TODO:设置表单验证让age不能为空
        if(value.get(5).equals("") || value.get(5) == null)
            this.age.setValue(0+"");
        else
            this.age = new Unit();
        this.contact = value.get(6);
        this.homephone = value.get(7);
        this.cellphone = value.get(8);
        this.workphone = value.get(9);
    }

    public Map<String,String> toMap(){
        Map<String,String> map = new LinkedHashMap<String,String>();
        map.put("hospitalID",hospitalID);
        map.put("caseID",caseID);
        map.put("date",date);
        map.put("name",name);
        map.put("sex",sex);
        map.put("age",age+"");
        map.put("contact",contact);
        map.put("homephone",homephone);
        map.put("cellphone",cellphone);
        map.put("workphone",workphone);
        return map;
    }

    @Override
    public String toString() {
        return "Crf1_1{" +
                "hospitalID='" + hospitalID + '\'' +
                ", caseID='" + caseID + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", homephone='" + homephone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", workphone='" + workphone + '\'' +
                '}';
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Unit getAge() {
        return age;
    }

    public void setAge(Unit age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }
}

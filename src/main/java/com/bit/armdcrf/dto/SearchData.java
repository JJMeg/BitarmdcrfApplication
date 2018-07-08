package com.bit.armdcrf.dto;

import com.bit.armdcrf.dictionary.CodeToValue;

import java.util.*;

/**
 * @author Debbie Qiu
 */
public class SearchData {
    private String caseID;
    private String hospitalID;
    private String name;
    private String ageMax;
    private String ageMin;
    private String sex;
    private String dateMax;
    private String dateMin;
    private List<String> preStudy;  //术前要做过哪些检查
    private List<String> postStage; //术后要做过哪几个阶段的检查
    private List<String> postStudy;  //术后要做过哪些检查


  //  private int searchPart;  高级检索不需要选择检索范围，每个检索条件已经被硬编码

    public String toQueryEL(){
        String query = "";
        Map<String, String> codeToValue = new CodeToValue().getCrf_1_1(); //TODO:spring ioc
        if(caseID != null && !caseID.equals("")) query += codeToValue.get("workphone") + ":" + caseID + " AND ";
        if(hospitalID !=null && !hospitalID.equals("")) query += codeToValue.get("hospitalID") + ":" + hospitalID + " AND ";
        if(name !=null && !name.equals("")) query += codeToValue.get("name") + ":" + name + " AND ";
        if(sex !=null && !sex.equals("")) query += codeToValue.get("sex") + ":" + sex + " AND ";
        if(ageMin !=null && !ageMin.equals("")){
            query += codeToValue.get("age") + ":[" + ageMin +" TO ";
        }
        else{
            query += codeToValue.get("age") + ":[0 TO "  ;
        }
        if(ageMax !=null && !ageMax.equals("")) {
            query += ageMax +"] AND " ;
        }
        else{
            query += "900] AND ";
        }


        if(dateMin !=null && !dateMin.equals("")){
            query += codeToValue.get("date") + ":[" + dateMin +" TO ";
        }
        else{
            query += codeToValue.get("date") + ":[0 TO ";
        }
        if(dateMax !=null && !dateMax.equals("")) {
            query += dateMax +"] AND " ;
        }
        else{
            query += "99999999] AND ";
        }

        if(!(preStudy == null ||preStudy.isEmpty())){
            for(String t:preStudy)
                query  +=  "术前" + t + "检查:有 AND ";
        }
        if(!(postStage == null || postStage.isEmpty())){
            if(!(postStudy == null || postStudy.isEmpty())) {
                for (String time : postStage)
                    for(String type: postStudy)
                    query += "术后" + time +type + "检查:有 AND ";
            }
        }
        //去掉最后的连接词AND

        return query.substring(0,query.length()-5);


    }


    public Map<String,Map<String,String>> toTerm()
    {
        Map<String,String> term = new HashMap<String, String>();
        Map<String,Map<String,String>> termSet = new HashMap<String,Map<String,String>>();
        if(caseID != null && !caseID.equals("")) term.put("caseID",caseID);
        if(hospitalID !=null && !hospitalID.equals("")) term.put("hospitalID",hospitalID);
        if(name !=null && !name.equals("")) term.put("name",name);
        if(sex !=null && !sex.equals("")) term.put("sex",sex);
        if(ageMax !=null && !ageMax.equals("")) term.put("ageMax",ageMax);
        if(ageMin !=null && !ageMin.equals("")) term.put("ageMin",ageMin);
        if(dateMax !=null && !dateMax.equals("")) term.put("dateMax",dateMax);
        if(dateMax !=null && !dateMax.equals("")) term.put("dateMin",dateMin);
        termSet.put(new String("1"),term);

        Map<String,String> termPre = new HashMap<String, String>();
        //TODO:先确定一下Term具体怎么设置再来完成这部分，即是存入list还是存入可重复的key值的内容
        if(preStudy != null && preStudy.size() != 0) {
            Map<String,String> pre = new LinkedHashMap<String, String>();
           // for(int i=0;i<preStudy.size();i++)

               // pre.put("");
        } ;
        termSet.put(new String("2"),termPre);

        Map<String,String> termPost = new HashMap<String, String>();
        if(postStage !=null && postStage.size() !=0) ;
        if(postStudy !=null && postStudy.size() !=0) ;
        termSet.put(new String("3"),termPost);

        return termSet;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }


    public String getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax;
    }

    public String getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin;
    }

    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public List<String> getPreStudy() {
        return preStudy;
    }

    public void setPreStudy(List<String> preStudy) {
        this.preStudy = preStudy;
    }

    public List<String> getPostStage() {
        return postStage;
    }

    public void setPostStage(List<String> postStage) {
        this.postStage = postStage;
    }

    public List<String> getPostStudy() {
        return postStudy;
    }

    public void setPostStudy(List<String> postStudy) {
        this.postStudy = postStudy;
    }
}

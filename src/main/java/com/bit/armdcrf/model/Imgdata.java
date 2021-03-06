package com.bit.armdcrf.model;

import java.io.Serializable;

public class Imgdata implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.hospitalId
     *
     * @mbggenerated
     */
    private String hospitalid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.patientId
     *
     * @mbggenerated
     */
    private String patientid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.patientName
     *
     * @mbggenerated
     */
    private String patientname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.patientSex
     *
     * @mbggenerated
     */
    private String patientsex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.patientAge
     *
     * @mbggenerated
     */
    private Integer patientage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.studyStage
     *
     * @mbggenerated
     */
    private String studystage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.importDate
     *
     * @mbggenerated
     */
    private String importdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.dataType
     *
     * @mbggenerated
     */
    private String datatype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.studyType
     *
     * @mbggenerated
     */
    private String studytype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ImgData.uri
     *
     * @mbggenerated
     */
    private String uri;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ImgData
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.id
     *
     * @return the value of ImgData.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.id
     *
     * @param id the value for ImgData.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.hospitalId
     *
     * @return the value of ImgData.hospitalId
     *
     * @mbggenerated
     */
    public String getHospitalid() {
        return hospitalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.hospitalId
     *
     * @param hospitalid the value for ImgData.hospitalId
     *
     * @mbggenerated
     */
    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.patientId
     *
     * @return the value of ImgData.patientId
     *
     * @mbggenerated
     */
    public String getPatientid() {
        return patientid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.patientId
     *
     * @param patientid the value for ImgData.patientId
     *
     * @mbggenerated
     */
    public void setPatientid(String patientid) {
        this.patientid = patientid == null ? null : patientid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.patientName
     *
     * @return the value of ImgData.patientName
     *
     * @mbggenerated
     */
    public String getPatientname() {
        return patientname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.patientName
     *
     * @param patientname the value for ImgData.patientName
     *
     * @mbggenerated
     */
    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.patientSex
     *
     * @return the value of ImgData.patientSex
     *
     * @mbggenerated
     */
    public String getPatientsex() {
        return patientsex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.patientSex
     *
     * @param patientsex the value for ImgData.patientSex
     *
     * @mbggenerated
     */
    public void setPatientsex(String patientsex) {
        this.patientsex = patientsex == null ? null : patientsex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.patientAge
     *
     * @return the value of ImgData.patientAge
     *
     * @mbggenerated
     */
    public Integer getPatientage() {
        return patientage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.patientAge
     *
     * @param patientage the value for ImgData.patientAge
     *
     * @mbggenerated
     */
    public void setPatientage(Integer patientage) {
        this.patientage = patientage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.studyStage
     *
     * @return the value of ImgData.studyStage
     *
     * @mbggenerated
     */
    public String getStudystage() {
        return studystage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.studyStage
     *
     * @param studystage the value for ImgData.studyStage
     *
     * @mbggenerated
     */
    public void setStudystage(String studystage) {
        this.studystage = studystage == null ? null : studystage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.importDate
     *
     * @return the value of ImgData.importDate
     *
     * @mbggenerated
     */
    public String getImportdate() {
        return importdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.importDate
     *
     * @param importdate the value for ImgData.importDate
     *
     * @mbggenerated
     */
    public void setImportdate(String importdate) {
        this.importdate = importdate == null ? null : importdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.dataType
     *
     * @return the value of ImgData.dataType
     *
     * @mbggenerated
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.dataType
     *
     * @param datatype the value for ImgData.dataType
     *
     * @mbggenerated
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.studyType
     *
     * @return the value of ImgData.studyType
     *
     * @mbggenerated
     */
    public String getStudytype() {
        return studytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.studyType
     *
     * @param studytype the value for ImgData.studyType
     *
     * @mbggenerated
     */
    public void setStudytype(String studytype) {
        this.studytype = studytype == null ? null : studytype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ImgData.uri
     *
     * @return the value of ImgData.uri
     *
     * @mbggenerated
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ImgData.uri
     *
     * @param uri the value for ImgData.uri
     *
     * @mbggenerated
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ImgData
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append("Hash:'").append(hashCode());
        sb.append("', id:'").append(id);
        sb.append("', hospitalid:'").append(hospitalid);
        sb.append("', patientid:'").append(patientid);
        sb.append("', patientname:'").append(patientname);
        sb.append("', patientsex:'").append(patientsex);
        sb.append("', patientage:'").append(patientage);
        sb.append("', studystage:'").append(studystage);
        sb.append("', importdate:'").append(importdate);
        sb.append("', datatype:'").append(datatype);
        sb.append("', studytype:'").append(studytype);
        sb.append("', uri:'").append(uri);
        sb.append("', serialVersionUID:'").append(serialVersionUID);
        sb.append("'}");
        return sb.toString();
    }
}
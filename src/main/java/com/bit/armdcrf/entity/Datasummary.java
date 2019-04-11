package com.bit.armdcrf.entity;

import java.util.Date;

public class Datasummary {
    /**
     * id
     */
    private Long id;

    /**
     * 病人姓名
     */
    private String patientname;

    /**
     * 病人id
     */
    private String patientid;

    /**
     * 收录人
     */
    private String creator;

    /**
     * 收录时间
     */
    private Date createtime;

    /**
     * 收录位置
     */
    private String location;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 文件数量
     */
    private Short filenum;

    /**
     * 所在文件服务器id
     */
    private Byte fileserver;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取病人姓名
     *
     * @return patientName - 病人姓名
     */
    public String getPatientname() {
        return patientname;
    }

    /**
     * 设置病人姓名
     *
     * @param patientname 病人姓名
     */
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    /**
     * 获取病人id
     *
     * @return patientId - 病人id
     */
    public String getPatientid() {
        return patientid;
    }

    /**
     * 设置病人id
     *
     * @param patientid 病人id
     */
    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    /**
     * 获取收录人
     *
     * @return creator - 收录人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置收录人
     *
     * @param creator 收录人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取收录时间
     *
     * @return createTime - 收录时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置收录时间
     *
     * @param createtime 收录时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取收录位置
     *
     * @return location - 收录位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置收录位置
     *
     * @param location 收录位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取文件名
     *
     * @return fileName - 文件名
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置文件名
     *
     * @param filename 文件名
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 获取文件数量
     *
     * @return fileNum - 文件数量
     */
    public Short getFilenum() {
        return filenum;
    }

    /**
     * 设置文件数量
     *
     * @param filenum 文件数量
     */
    public void setFilenum(Short filenum) {
        this.filenum = filenum;
    }

    /**
     * 获取所在文件服务器id
     *
     * @return fileServer - 所在文件服务器id
     */
    public Byte getFileserver() {
        return fileserver;
    }

    /**
     * 设置所在文件服务器id
     *
     * @param fileserver 所在文件服务器id
     */
    public void setFileserver(Byte fileserver) {
        this.fileserver = fileserver;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
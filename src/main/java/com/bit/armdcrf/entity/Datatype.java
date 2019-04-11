package com.bit.armdcrf.entity;

public class Datatype {
    /**
     * id
     */
    private Short id;

    /**
     * 数据id
     */
    private Long datasummaryid;

    /**
     * 手术术式
     */
    private String surprocedure;

    /**
     * 成像部位
     */
    private String imagesite;

    /**
     * 病变类型
     */
    private String lesiontype;

    /**
     * 成像类型
     */
    private String imagetype;

    /**
     * 来源渠道
     */
    private String source;

    /**
     * 采集阶段
     */
    private String stage;

    /**
     * 是否金标准
     */
    private Boolean goldstandard;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取数据id
     *
     * @return dataSummaryId - 数据id
     */
    public Long getDatasummaryid() {
        return datasummaryid;
    }

    /**
     * 设置数据id
     *
     * @param datasummaryid 数据id
     */
    public void setDatasummaryid(Long datasummaryid) {
        this.datasummaryid = datasummaryid;
    }

    /**
     * 获取手术术式
     *
     * @return surProcedure - 手术术式
     */
    public String getSurprocedure() {
        return surprocedure;
    }

    /**
     * 设置手术术式
     *
     * @param surprocedure 手术术式
     */
    public void setSurprocedure(String surprocedure) {
        this.surprocedure = surprocedure;
    }

    /**
     * 获取成像部位
     *
     * @return imageSite - 成像部位
     */
    public String getImagesite() {
        return imagesite;
    }

    /**
     * 设置成像部位
     *
     * @param imagesite 成像部位
     */
    public void setImagesite(String imagesite) {
        this.imagesite = imagesite;
    }

    /**
     * 获取病变类型
     *
     * @return lesionType - 病变类型
     */
    public String getLesiontype() {
        return lesiontype;
    }

    /**
     * 设置病变类型
     *
     * @param lesiontype 病变类型
     */
    public void setLesiontype(String lesiontype) {
        this.lesiontype = lesiontype;
    }

    /**
     * 获取成像类型
     *
     * @return imageType - 成像类型
     */
    public String getImagetype() {
        return imagetype;
    }

    /**
     * 设置成像类型
     *
     * @param imagetype 成像类型
     */
    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    /**
     * 获取来源渠道
     *
     * @return source - 来源渠道
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源渠道
     *
     * @param source 来源渠道
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取采集阶段
     *
     * @return stage - 采集阶段
     */
    public String getStage() {
        return stage;
    }

    /**
     * 设置采集阶段
     *
     * @param stage 采集阶段
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * 获取是否金标准
     *
     * @return goldStandard - 是否金标准
     */
    public Boolean getGoldstandard() {
        return goldstandard;
    }

    /**
     * 设置是否金标准
     *
     * @param goldstandard 是否金标准
     */
    public void setGoldstandard(Boolean goldstandard) {
        this.goldstandard = goldstandard;
    }
}
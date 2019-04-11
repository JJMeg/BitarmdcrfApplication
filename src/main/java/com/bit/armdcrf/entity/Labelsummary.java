package com.bit.armdcrf.entity;

public class Labelsummary {
    /**
     * id
     */
    private Short id;

    /**
     * 标签名
     */
    private String labelkey;

    /**
     * 标签值
     */
    private String labelvalue;

    /**
     * 标签值描述
     */
    private String description;


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
     * 获取标签名
     *
     * @return labelKey - 标签名
     */
    public String getLabelkey() {
        return labelkey;
    }

    /**
     * 设置标签名
     *
     * @param labelkey 标签名
     */
    public void setLabelkey(String labelkey) {
        this.labelkey = labelkey;
    }

    /**
     * 获取标签值
     *
     * @return labelValue - 标签值
     */
    public String getLabelvalue() {
        return labelvalue;
    }

    /**
     * 设置标签值
     *
     * @param labelvalue 标签值
     */
    public void setLabelvalue(String labelvalue) {
        this.labelvalue = labelvalue;
    }

    /**
     * 获取标签值描述
     *
     * @return labelValue - 标签值
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置标签值描述
     *
     * @param description 标签值
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
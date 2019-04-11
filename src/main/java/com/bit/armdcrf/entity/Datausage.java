package com.bit.armdcrf.entity;

public class Datausage {
    /**
     * id
     */
    private Short id;

    /**
     * 分割
     */
    private String segment;

    /**
     * 配准
     */
    private String registration;

    /**
     * 重建
     */
    private String reconstruct;

    /**
     * 增强现实
     */
    private String vr;

    /**
     * 图像复原
     */
    private String restoration;

    /**
     * 特征匹配
     */
    private String feature;

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
     * 获取分割
     *
     * @return segment - 分割
     */
    public String getSegment() {
        return segment;
    }

    /**
     * 设置分割
     *
     * @param segment 分割
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /**
     * 获取配准
     *
     * @return registration - 配准
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * 设置配准
     *
     * @param registration 配准
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * 获取重建
     *
     * @return reconstruct - 重建
     */
    public String getReconstruct() {
        return reconstruct;
    }

    /**
     * 设置重建
     *
     * @param reconstruct 重建
     */
    public void setReconstruct(String reconstruct) {
        this.reconstruct = reconstruct;
    }

    /**
     * 获取增强现实
     *
     * @return VR - 增强现实
     */
    public String getVr() {
        return vr;
    }

    /**
     * 设置增强现实
     *
     * @param vr 增强现实
     */
    public void setVr(String vr) {
        this.vr = vr;
    }

    /**
     * 获取图像复原
     *
     * @return restoration - 图像复原
     */
    public String getRestoration() {
        return restoration;
    }

    /**
     * 设置图像复原
     *
     * @param restoration 图像复原
     */
    public void setRestoration(String restoration) {
        this.restoration = restoration;
    }

    /**
     * 获取特征匹配
     *
     * @return feature - 特征匹配
     */
    public String getFeature() {
        return feature;
    }

    /**
     * 设置特征匹配
     *
     * @param feature 特征匹配
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }
}
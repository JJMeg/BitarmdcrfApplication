package com.bit.armdcrf.dto;
import com.bit.armdcrf.model.Imgdata;
import java.util.List;

/**
 * @author Debbie Qiu
 */

public class ImgData {
    private Imgdata imgdata;
    private List<String> uris;

    public Imgdata getImgdata() {
        return imgdata;
    }

    public void setImgdata(Imgdata imgdata) {
        this.imgdata = imgdata;
    }

    public List<String> getUris() {
        return uris;
    }

    public void setUris(List<String> uris) {
        this.uris = uris;
    }



}


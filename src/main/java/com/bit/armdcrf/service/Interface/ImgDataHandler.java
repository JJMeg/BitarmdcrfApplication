package com.bit.armdcrf.service.Interface;

import com.bit.armdcrf.dto.ImgData;
import com.bit.armdcrf.dto.SearchData;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.model.Imgdata;

import java.util.List;

/**
 * @author Debbie Qiu
 */
public interface ImgDataHandler {

    public List<ImgData> search(SearchData searchData);
    public List<ImgData> searchByExpress(String data);
    public List<String> add(String uri);
    public int delete(String id,boolean diskClean);
    public int update(Imgdata imgdata);
    public int addSingle(Imgdata imgdata);
    public int move(String fileUrl,String aimPath);
    public List<String> viewImg(String uris);
    public String viewVideo(String uris);


}

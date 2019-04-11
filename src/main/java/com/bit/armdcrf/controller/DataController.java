package com.bit.armdcrf.controller;

import com.alibaba.fastjson.JSONObject;
import com.bit.armdcrf.dto.ImgData;
import com.bit.armdcrf.dto.SearchData;
import com.bit.armdcrf.dto.WordData;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.entity.Crf.Crf2_1;
import com.bit.armdcrf.model.Imgdata;
import com.bit.armdcrf.service.Interface.ImgDataHandler;
import com.bit.armdcrf.service.Interface.WordDataAcquire;
import com.bit.armdcrf.service.Interface.WordDataHandler;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

/**
 * 本类中是进行数据操作的Controller
 */
@RestController
@RequestMapping("data")
public class DataController {
    @Autowired
    WordDataAcquire wordDataAcquire;
    @Autowired
    WordDataHandler wordDataHandler;
    @Autowired
    ImgDataHandler imgDataHandler;


    /**
     * 导入数据，
     * 将uri路径下所有符合条件的Word文件进行索引，
     * 新建索引文件或添加到原有索引文件。
     * @param uri
     * @return 返回带有处理信息的json数据
     */

    @RequestMapping(value="import",method = RequestMethod.POST)
    public Map<String,String> importFile(@RequestParam("file.uri") String uri){

        boolean flag =  wordDataHandler.add(uri);

        Map<String,String> result = new HashMap<String, String>();
        if(flag) {
            result.put("result", "success");
            result.put("mess", "导入成功");
        }
        else{
            result.put("result", "fail");
            result.put("mess", "导入失败，请联系管理员！");
        }

        return result;

    }


    /**
     * 导入Word文本数据，
     * 将uri路径下所有符合条件的Word文件进行索引，
     * 新建索引文件或添加到原有索引文件。
     * @param uri
     * @return 返回带有处理信息的json数据
     */

    @RequestMapping(value="importword",method = RequestMethod.POST)
    public Map<String,String> importWord(@RequestParam("word.uri") String uri){

      boolean flag =  wordDataHandler.add(uri);

       Map<String,String> result = new HashMap<String, String>();
       if(flag) {
           result.put("result", "success");
           result.put("mess", "导入成功");
       }
       else{
           result.put("result", "fail");
           result.put("mess", "导入失败，请联系管理员！");
       }

        return result;

    }

    @RequestMapping(value = "importimg",method = RequestMethod.POST)
    public Map<String,String> importImg(@RequestParam("img.uri") String uri){
        //TODO:具体导入逻辑代码

        List<String> failFile = imgDataHandler.add(uri);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result","success");
        result.put("mess","导入成功");

        return result;
    }

    @RequestMapping(value = "import_info_img",method = RequestMethod.POST)
    public Map<String,String> importInfoImg(Imgdata data){
        //TODO:具体导入逻辑代码

        Imgdata imgData = data;

        int r = imgDataHandler.addSingle(imgData);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result","success");
        result.put("mess","导入成功");

        return result;
    }

    @RequestMapping(value = "crf_text",method = RequestMethod.POST)
    public Map<String,List<String>> getCrfText(String crf_part,String uri){
        Map<String ,List<String> > result = new HashMap<String, List<String>>();
        List<String> content = wordDataAcquire.getCrfPartLines(crf_part,uri);  // （eg:crf_part=1-1或者1-2或者2-2）
        result.put("content",content);
        return result;
    }

    @RequestMapping(value = "search_word", method = RequestMethod.POST)
    public List<WordData> searchWord(SearchData data){
        SearchData searchData = data;
        List<WordData> rs = wordDataHandler.advancedSearch(searchData);

        Map<String ,String > result = new HashMap<String, String>();
        result.put("content","成功！");
        result.put("statusCode","200");
        return rs;
    }

    @RequestMapping(value = "search_word_express", method = RequestMethod.POST)
    public List<WordData> searchWordExpress(String data){
        if(data.length()>4)
            data = data.substring(5);
        List<WordData> rs = wordDataHandler.search(data);
        if(rs == null)
            return new ArrayList<>();
        else
            return rs;
    }

    @RequestMapping(value = "search_img_express", method = RequestMethod.POST)
    public List<JSONObject> searchImgExpress(String data){
        if(data.length()>4)
            data = data.substring(5);
        List<JSONObject> json = new LinkedList<JSONObject>();
        List<ImgData> imgdata = imgDataHandler.searchByExpress(data);
        for(ImgData imgData:imgdata) {
            String s = imgData.getImgdata().toString();
            JSONObject jsonImg = JSONObject.parseObject(s);
            JSONObject jsonUri = JSONObject.parseObject("{uris:'"+imgData.getUris().toString()+"'}");
            jsonImg.putAll(jsonUri);
            json.add(jsonImg);

        }
        return json;
    }

    @RequestMapping(value = "search_img_advanced", method = RequestMethod.POST)
    public List<JSONObject> searchImg(SearchData data) {
        List<JSONObject> json = new LinkedList<JSONObject>();
        List<ImgData> imgdata = imgDataHandler.search(data);
        for(ImgData imgData:imgdata) {
            String s = imgData.getImgdata().toString();
            JSONObject jsonImg = JSONObject.parseObject(s);
            JSONObject jsonUri = JSONObject.parseObject("{uris:'"+imgData.getUris().toString()+"'}");
            jsonImg.putAll(jsonUri);
            json.add(jsonImg);

        }

        return json;
    }

    @RequestMapping(value = "view_img", method = RequestMethod.POST)
    public List<String> viewImg(String uris){

        return imgDataHandler.viewImg(uris);

    }

    @RequestMapping(value = "view_video", method = RequestMethod.POST)
    public Map<String,String> viewVideo(String uris){
        Map<String,String> result= new HashMap<>();

        result.put("uri",imgDataHandler.viewVideo(uris));
        return result;

    }



    @RequestMapping(value = "edit_word", method = RequestMethod.POST)
    public String viewWord(String crf_part, String uri){


        String string = JSONObject.toJSONString(wordDataHandler.viewWord(uri,crf_part));
        return string;

    }
    @RequestMapping(value = "update_word", method = RequestMethod.POST)
    public Map<String,String> updateWord(Crf2_1 crf2_1,String uri){

        wordDataHandler.updateWord(crf2_1,uri);
        Map<String,String> result = new HashMap<>();
        result.put("result", "success");
        result.put("mess", "导入成功");
        return result;

    }
}

package com.bit.armdcrf.controller;

import com.bit.armdcrf.service.Impl.analysisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("import")
public class ImportController {
  @Autowired
  analysisServiceImpl analysisService;

  @ResponseBody
  @RequestMapping(value = "importdir", method = RequestMethod.POST)
  public Map<String, String> getJson(@RequestParam("word.uri") String uri) {

    //File f = analysisService.getYamlFile(uri);
    Map<String, String> result = new HashMap<String, String>();
    return result;
  }

  @ResponseBody
  @RequestMapping(value = "analyse", method = RequestMethod.POST)
  public Map<String, Object> analyseDir(@RequestParam("dir.uri") String uri) {
    System.out.println(uri);
    Map<String, Object> result = new HashMap<>();
    try {
      File f = analysisService.getYamlFile(uri);
      if (f != null) {
        Map<Object, Object> r = analysisService.analyseYaml(f);
        Map<String, Object> r1 = new HashMap<>();
        if (r != null) {
            analysisService.analyseJsonMap(r, r1);
          if (r1 != null) {
            result.put("result", "success");
            result.put("mess", "导入成功");
            result.putAll(r1);
            System.out.println("r1:"+result);
          } else {
            result.put("result", "success");
            result.put("mess", "失败");
          }
        }
      } else {
        result.put("result", "success");
        result.put("mess", "失败");
      }
    }catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return result;
  }

}

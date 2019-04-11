package com.bit.armdcrf.controller;

import com.bit.armdcrf.service.Impl.analysisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ImportController {
  @Autowired
  analysisServiceImpl analysisService;

  @ResponseBody
  @RequestMapping(value = "importdir",method = RequestMethod.POST)
  public Map<String,String> getJson(@RequestParam("word.uri") String uri){
    File f = analysisService.getYamlFile(uri);
    Map<String,String> result = new HashMap<String, String>();
    return result;
  }
}

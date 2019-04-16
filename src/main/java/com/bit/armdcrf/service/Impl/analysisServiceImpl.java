package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.service.analysisService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class analysisServiceImpl implements analysisService {
  private static Logger logger = Logger.getLogger(analysisServiceImpl.class.getName());

  @Override
  public File getYamlFile(String dirPath) {
    String filePrefix = ".yaml";
    File dirFile = new File(dirPath);
    if (!dirFile.exists() || !dirFile.isDirectory()) {
      return null;
    }
    for (File f : dirFile.listFiles()) {
      System.out.println(f.getName());
      if (f.getName().contains(filePrefix)) {
        logger.info("get yaml file: "+ f.getName());
        return f;
      }
    }
    return null;
  }

  @Override
  public Map<Object, Object> analyseYaml(File yamlFile) {
    Yaml yaml = new Yaml();
    Map<Object, Object> jsonMap = new HashMap<>();
    try {
      jsonMap = yaml.load(new FileInputStream(yamlFile));
      System.out.println(jsonMap.toString());
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Exception in analysisYaml: " + yamlFile.getName(), e);
    }
    return jsonMap;
  }

  @Override
  public Map<String, Object> analyseJsonMap(Map<Object, Object> jsonMap,Map<String, Object> result) {
    if(jsonMap == null){
      return result;
    }
    for (Object key : jsonMap.keySet()){
      if (jsonMap.get(key).getClass() == String.class){
        String k = key.toString().trim();
        if (k.compareTo("surProcedure")==0){
          result.put("surProcedure",jsonMap.get(key).toString());
        }else if (k.compareTo("imageSite")==0){
          result.put("imageSite",jsonMap.get(key).toString());
        }else if (k.compareTo("lesionType")==0){
          result.put("lesionType",jsonMap.get(key).toString());
        }else if (k.compareTo("imageType")==0){
          result.put("imageType",jsonMap.get(key).toString());
        }else if (k.compareTo("source")==0){
          result.put("source",jsonMap.get(key).toString());
        }else if (k.compareTo("stage")==0){
          result.put("stage",jsonMap.get(key).toString());
        }else if (k.compareTo("goldStandard")==0){
          if (jsonMap.get(key).toString().compareTo("YES")==0) {
            result.put("goldStandard", true);
          }else if (jsonMap.get(key).toString().compareTo("NO")==0) {
            result.put("goldStandard", false);
          }
        }else if (k.compareTo("segment")==0){
          result.put("segment",jsonMap.get(key).toString());
        }else if (k.compareTo("registration")==0){
          result.put("registration",jsonMap.get(key).toString());
        }else if (k.compareTo("reconstruct")==0){
          result.put("reconstruct",jsonMap.get(key).toString());
        }else if (k.compareTo("VR")==0){
          result.put("VR",true);
        }else if (k.compareTo("restoration")==0){
          result.put("restoration",true);
        }else if (k.compareTo("feature")==0){
          result.put("feature",true);
        }
      }else{
        analyseJsonMap((Map<Object, Object>)jsonMap.get(key),result);
      }
    }
    return result;
  }
}

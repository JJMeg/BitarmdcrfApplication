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
  public Map<String, String> analyseYaml(File yamlFile) {
    Yaml yaml = new Yaml();
    Map<String, String> jsonMap = new HashMap<>();
    try {
      jsonMap = yaml.load(new FileInputStream(yamlFile));
      System.out.println(jsonMap.toString());
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Exception in analysisYaml: " + yamlFile.getName(), e);
    }
    return jsonMap;
  }
}

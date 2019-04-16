package com.bit.armdcrf.service;

import java.io.File;
import java.util.Map;

public interface analysisService {
  public File getYamlFile(String dirPath);

  public Map<Object, Object> analyseYaml(File yamlFile);

  public Map<String, Object> analyseJsonMap(Map<Object, Object> jsonMap,Map<String, Object> result);
}

package com.bit.armdcrf.service;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

public interface analysisService {
  public File getYamlFile(String dirPath) throws URISyntaxException;

  public Map<Object, Object> analyseYaml(File yamlFile);

  public Map<String, Object> analyseJsonMap(Map<Object, Object> jsonMap,Map<String, Object> result);
}

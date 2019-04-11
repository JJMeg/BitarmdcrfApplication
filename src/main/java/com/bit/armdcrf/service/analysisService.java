package com.bit.armdcrf.service;

import java.io.File;
import java.util.Map;

public interface analysisService {
  public File getYamlFile(String dirPath);

  public Map<String, String> analyseYaml(File yamlFile);
}

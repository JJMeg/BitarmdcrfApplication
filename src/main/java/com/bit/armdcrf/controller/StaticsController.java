package com.bit.armdcrf.controller;

import com.bit.armdcrf.service.dataSummaryService;
import com.bit.armdcrf.service.dataTypeService;
import com.bit.armdcrf.service.dataUsageService;
import com.bit.armdcrf.service.labaelSummaryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/statics")
public class StaticsController {
  private static final Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  private dataSummaryService dataSummaryService;
  private dataTypeService dataTypeService;
  private dataUsageService  dataUsageService;
  private labaelSummaryService labaelSummaryService;

  @RequestMapping(value = "/asserts", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Integer> asserts() {
    Map<String,Integer> results = new HashMap<>();

    return results;
  }

}

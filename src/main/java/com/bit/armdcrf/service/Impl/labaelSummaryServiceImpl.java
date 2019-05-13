package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.labelSummaryDao;
import com.bit.armdcrf.service.labaelSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class labaelSummaryServiceImpl implements labaelSummaryService {

  @Autowired
  private labelSummaryDao labelSummaryDao;

  @Override
  public List<String> getAllLabels(String label) {
    return labelSummaryDao.getBylabelKey(label);
  }
}

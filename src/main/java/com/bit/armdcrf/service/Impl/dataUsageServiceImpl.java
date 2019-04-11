package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.entity.Datausage;
import com.bit.armdcrf.service.dataUsageService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class dataUsageServiceImpl implements dataUsageService {
  @Override
  public Datausage getBySummaryId(Long id) {
    return null;
  }

  @Override
  public List<Long> getAllBySegment(String segment) {
    return null;
  }

  @Override
  public List<Long> getAllByRegistration(String registration) {
    return null;
  }

  @Override
  public List<Long> getAllByReconstruct(String reconstruct) {
    return null;
  }

  @Override
  public List<Long> getAllByVR(String VR) {
    return null;
  }

  @Override
  public List<Long> getAllByRestoration(String restoration) {
    return null;
  }

  @Override
  public List<Long> getAllByFeature(String feature) {
    return null;
  }
}

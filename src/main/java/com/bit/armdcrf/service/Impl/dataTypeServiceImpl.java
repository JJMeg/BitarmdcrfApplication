package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.dataTypeDao;
import com.bit.armdcrf.entity.Datasummary;
import com.bit.armdcrf.service.dataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class dataTypeServiceImpl implements dataTypeService {

  @Autowired
  private dataTypeDao dataTypeDao;

  @Override
  public Datasummary getBySummaryId(Long id) {
    return dataTypeDao.getBySummaryId(id);
  }

  @Override
  public List<Long> getAllBySurProcedure(String surProcedure) {
    return dataTypeDao.getAllBySurProcedure(surProcedure);
  }

  @Override
  public List<Long> getAllByImageSite(String imageSite) {
    return dataTypeDao.getAllByImageSite(imageSite);
  }

  @Override
  public List<Long> getAllByLesionType(String lesionType) {
    return dataTypeDao.getAllByLesionType(lesionType);
  }

  @Override
  public List<Long> getAllByImageType(String imageType) {
    return dataTypeDao.getAllByImageType(imageType);
  }

  @Override
  public List<Long> getAllBySource(String source) {
    return dataTypeDao.getAllBySource(source);
  }

  @Override
  public List<Long> getAllByStage(String stage) {
    return dataTypeDao.getAllByStage(stage);
  }

  @Override
  public List<Long> getAllByGoldStandard(boolean goldStandard) {
    return dataTypeDao.getAllByGoldStandard(goldStandard);
  }
}

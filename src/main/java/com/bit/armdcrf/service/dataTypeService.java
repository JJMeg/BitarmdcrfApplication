package com.bit.armdcrf.service;

import com.bit.armdcrf.entity.Datasummary;

import java.util.List;

public interface dataTypeService {
  public Datasummary getBySummaryId(Long id);

  public List<Long> getAllBySurProcedure(String surProcedure);

  public List<Long> getAllByImageSite(String imageSite);

  public List<Long> getAllByLesionType(String lesionType);

  public List<Long> getAllByImageType(String imageType);

  public List<Long> getAllBySource(String source);

  public List<Long> getAllByStage(String stage);

  public List<Long> getAllByGoldStandard(boolean goldStandard);

}

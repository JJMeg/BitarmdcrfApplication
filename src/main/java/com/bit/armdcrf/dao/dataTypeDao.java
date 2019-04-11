package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.Datasummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface dataTypeDao {
  public Datasummary getBySummaryId(Long summaryId);

  public List<Long> getAllBySurProcedure(String surProcedure);

  public List<Long> getAllByImageSite(String imageSite);

  public List<Long> getAllByLesionType(String lesionType);

  public List<Long> getAllByImageType(String imageType);

  public List<Long> getAllBySource(String source);

  public List<Long> getAllByStage(String stage);

  public List<Long> getAllByGoldStandard(boolean goldStandard);

}

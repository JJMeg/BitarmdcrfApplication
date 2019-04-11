package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.Labelsummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface labelSummaryDao {
  public List<String> getBylabelKey(String labelKey);

  public List<Labelsummary> getAllBylabelKey(String labelKey);

}

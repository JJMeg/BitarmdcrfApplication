package com.bit.armdcrf.service;

import com.bit.armdcrf.entity.Datasummary;

import java.util.List;

public interface dataSummaryService {
  public Datasummary getById(Long id);

  public List<Datasummary> getByPatientName(String patientname);

  public List<Datasummary> getByPatientId(String patientid);

  public List<Datasummary> getByCreator(String creator);

  public List<Datasummary> getByFileName(String filename);

  public List<Datasummary> getByFileServer(int fileserver);

  public int getSumOfAll();

  public int getSumByCreator();
}

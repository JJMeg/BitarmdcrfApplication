package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.dataSummaryDao;
import com.bit.armdcrf.entity.Datasummary;
import com.bit.armdcrf.service.dataSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class dataSummaryImpl implements dataSummaryService {

  @Autowired
  private dataSummaryDao dataSummaryDao;

  @Override
  public Datasummary getById(Long id) {
    return dataSummaryDao.getById(id);
  }

  @Override
  public List<Datasummary> getByPatientName(String patientname) {
    return dataSummaryDao.getByPatientName(patientname);
  }

  @Override
  public List<Datasummary> getByPatientId(String patientid) {
    return dataSummaryDao.getByPatientId(patientid);
  }

  @Override
  public List<Datasummary> getByCreator(String creator) {
    return dataSummaryDao.getByCreator(creator);
  }

  @Override
  public List<Datasummary> getByFileName(String filename) {
    return dataSummaryDao.getByFileName(filename);
  }

  @Override
  public List<Datasummary> getByFileServer(int fileserver) {
    return dataSummaryDao.getByFileServer(fileserver);
  }


}

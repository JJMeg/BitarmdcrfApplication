package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.fileServerDao;
import com.bit.armdcrf.entity.Fileserver;
import com.bit.armdcrf.service.fileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class fileServerServiceImpl implements fileServerService {

  @Autowired
  private fileServerDao fileServerDao;

  @Override
  public Fileserver getById(Long id) {
    return fileServerDao.getById(id);
  }

  @Override
  public Fileserver getByName(String name) {
    return fileServerDao.getByName(name);
  }

  @Override
  public Fileserver getByIp(String ip) {
    return fileServerDao.getByIp(ip);
  }
}

package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.fileServerDao;
import com.bit.armdcrf.entity.Fileserver;
import com.bit.armdcrf.service.fileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

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



  @Override
  public boolean judgeIP(String ip) {
    String regex = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
    Pattern pattern = Pattern.compile(regex);
    if (pattern.matcher(ip).matches()) {
      return true;
    }
    return false;
  }

  @Override
  public boolean addFileServer(Fileserver fileserver) {
    if (fileServerDao.addServer(fileserver) > 0){
      return true;
    }
    return false;
  }

  @Override
  public Fileserver getByNameIp(String name, String ip) {
    Fileserver fileserverInDB = fileServerDao.getByNameIp(name,ip);
    System.out.println(fileserverInDB.getName() + fileserverInDB.getIp());
    return fileserverInDB;
  }
}

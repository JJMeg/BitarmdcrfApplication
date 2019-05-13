package com.bit.armdcrf.service;

import com.bit.armdcrf.entity.Fileserver;

import java.util.List;
import java.util.Map;

public interface fileServerService {
  public Fileserver getById(Long id);

  public Fileserver getByName(String name);

  public Fileserver getByIp(String ip);

  public boolean judgeIP(String ip);

  public boolean addFileServer(Fileserver fileserver);

  public Fileserver getByNameIp(String name,String ip);

  public List<Fileserver> getListByName(String str);
}

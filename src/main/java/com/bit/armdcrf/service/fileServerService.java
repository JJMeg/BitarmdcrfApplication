package com.bit.armdcrf.service;

import com.bit.armdcrf.entity.Fileserver;

public interface fileServerService {
  public Fileserver getById(Long id);

  public Fileserver getByName(String name);

  public Fileserver getByIp(String ip);
}

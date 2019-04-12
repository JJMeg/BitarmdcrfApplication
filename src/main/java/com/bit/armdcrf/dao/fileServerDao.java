package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.Fileserver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fileServerDao {
  public Fileserver getById(Long id);

  public Fileserver getByName(String name);

  public Fileserver getByIp(String ip);

  public int addServer(Fileserver fileserver);

  public Fileserver getByNameIp(String name,String ip);

}

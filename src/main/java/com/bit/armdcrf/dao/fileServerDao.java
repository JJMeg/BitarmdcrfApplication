package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.Fileserver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface fileServerDao {
  public Fileserver getById(Long id);

  public Fileserver getByName(String name);

  public Fileserver getByIp(String ip);

  public int addServer(Fileserver fileserver);

  public Fileserver getByNameIp(String name,String ip);

  public List<Fileserver> getListByName(@Param("name")String name);

  public List<Fileserver> getListByIp(@Param("ip")String ip);

}

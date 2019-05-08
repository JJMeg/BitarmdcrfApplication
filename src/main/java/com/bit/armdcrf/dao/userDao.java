package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userDao {
  //  Dao接口的方法需要与MapperXML对应

  User getByUsername(@Param("username")String username);

  void addUser(User record);

  List<User> getAllUser();

  List<User> getListByUsername(@Param("username")String username);

}

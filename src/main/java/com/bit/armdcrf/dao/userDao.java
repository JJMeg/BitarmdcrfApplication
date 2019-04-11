package com.bit.armdcrf.dao;

import com.bit.armdcrf.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userDao {
  //  Dao接口的方法需要与MapperXML对应

  User getByUsername(String username);

  void addUser(User record);

  List<User> getAllUser();

}

package com.bit.armdcrf.service;

import com.bit.armdcrf.entity.User;
//import com.github.pagehelper.PageInfo;

import java.util.List;

public interface userService {
  void insert(User u);

  void addUser(User u);

  List<User> findAllUser(int pageNum, int pageSize);

  User getByUsername(String username);

  List<User> getAllUser();

  List<User> getListByUsername(String username);

}

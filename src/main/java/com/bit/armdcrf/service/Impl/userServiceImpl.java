package com.bit.armdcrf.service.Impl;

import com.bit.armdcrf.dao.userDao;
import com.bit.armdcrf.entity.User;
import com.bit.armdcrf.service.userService;
//import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class userServiceImpl implements userService {

  @Autowired
  private userDao userDao;

  @Override
  public void insert(User u) {
    System.out.println(u.getUsername());

  }

  @Override
  @Transactional
  public void addUser(User u) {
    userDao.addUser(u);
  }

  @Override
  public User getByUsername(String username) {
    return userDao.getByUsername(username);
  }

  @Override
  public List<User> getAllUser() {
    return userDao.getAllUser();
  }

  @Override
  public List<User> findAllUser(int pageNum, int pageSize) {
    return null;
  }


//  @Autowired
// // private userDao userDao;
//
//  @Override
//  public int insert(user u) {
//    u.setUserName("testtest");
//    u.setUserPwd("qazwsx");
//    u.setRoleId(0);
//    int addStatus = userDao.insert(u);
//    return addStatus;
//  }
//
//  @Override
//  public PageInfo<user> findAllUser(int pageNum, int pageSize) {
//    PageHelper.startPage(pageNum, pageSize);
//    List<user> userDomains = userDao.selectUsers();
//    PageInfo result = new PageInfo(userDomains);
//    return result;
//  }


}

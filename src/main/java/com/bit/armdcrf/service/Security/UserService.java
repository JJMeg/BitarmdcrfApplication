package com.bit.armdcrf.service.Security;

import com.bit.armdcrf.dao.RoleMapper;
import com.bit.armdcrf.dao.UserMapper;
import com.bit.armdcrf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Debbie Qiu
 */
@Component
public class UserService  {

    @Autowired
    UserMapper userMapper;

    public User findByName(String userName){
        return userMapper.selectByName(userName);
    }
}

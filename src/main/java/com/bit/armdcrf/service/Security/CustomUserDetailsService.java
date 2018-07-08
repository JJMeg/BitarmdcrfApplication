package com.bit.armdcrf.service.Security;

import com.bit.armdcrf.model.SecurityUser;
import com.bit.armdcrf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Debbie Qiu
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SysUser中的name作为用户名:
        User user = userService.findByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser seu = new SecurityUser(user);
        return  seu;
    }
}

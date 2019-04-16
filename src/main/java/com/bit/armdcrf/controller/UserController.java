package com.bit.armdcrf.controller;

import com.bit.armdcrf.entity.User;
import com.bit.armdcrf.entity.response;
import com.bit.armdcrf.service.userService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private userService userService;

    @RequestMapping("/getuser")
    @ResponseBody
    public User getuser() {
      User u = new User();
      u.setRoleid((byte) 0);
      u.setUsername("Meg");
      u.setUserpwd("123123");
      User uu = userService.getByUsername("meg");
      System.out.println(u);
      //analysisService.getYamlFile("/Users/jjmeg/IdeaProjects/manual_management/src/main/java/com/bit/management/manual_management/Analysis");
      return uu;
    }

    @RequestMapping("/getuserJson")
    @ResponseBody
    public response getuserJson() {
      User u = new User();
      u.setRoleid((byte) 0);
      u.setUsername("Meg");
      u.setUserpwd("123");
      return response.ok(u);
    }

    @RequestMapping("/getuserJsonTest")
    public String getuserJsonTest(ModelMap map) {
      User u = new User();
      u.setRoleid((byte) 0);
      u.setUsername("Meg");
      u.setUserpwd("123");
      map.addAttribute("user", u);
      return "freemarker";
    }

    @RequestMapping(value = "/testSQL")
    @ResponseBody
    public User testSQL() {
      User u = new User();
      u.setUserpwd("qaz");
      u.setUsername("123");
      u.setRoleid((byte) 0);
      userService.addUser(u);

      return u;
    }

    /**
     * 注册新用户
     *
     * @return response
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public response addUser(User u) {
      u.setRoleid((byte) 0);

      userService.addUser(u);
      return response.ok();
    }

    /**
     * 注册新用户
     *
     * @return response
     */
    @RequestMapping("/register")
    @ResponseBody
    public response register(User u) {
      userService.addUser(u);
      return response.ok();
    }

    /**
     * 获取所有用户
     *
     * @return users list
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
      List<User> users = userService.getAllUser();
      return users;
    }

    /**
     * 获取所有用户
     *
     * @return users list
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(User u) {
      User user = userService.getByUsername(u.getUsername());
      if (user.getUserpwd().compareTo(u.getUserpwd()) == 0){
        return "index";
      }
      return "error";
    }


}

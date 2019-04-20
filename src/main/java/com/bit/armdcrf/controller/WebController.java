package com.bit.armdcrf.controller;

import com.alibaba.fastjson.JSONArray;
import com.bit.armdcrf.dictionary.CodeToValue;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebController {

    @Autowired
    DefaultKaptcha defaultKaptcha;


    @ResponseBody
    @RequestMapping("/wordlist")
    public List<String> searchWordList() throws IOException{
        CodeToValue codeToValue  = new CodeToValue();
        List<String> list = new ArrayList<String>();
        Map<String,String> words = codeToValue.getAll();
        for(Map.Entry<String,String > map:words.entrySet()){
            list.add(map.getValue());
        }
        return list;
    }



    @ResponseBody
    @RequestMapping("/menu-form")
    public JSONArray crfWordResolveTest() throws IOException {

        JSONArray jsonObject = JSONArray.parseArray("[" +
//                "    {'name':'用户管理','children':[" +
//                "    {'id':'user-tree', 'name':'用户管理', 'target':'navtab', 'url':'html/form/user-tree.html'}" +
//                "    ]}" +
                "    {'name':'0智能导入', 'children':[" +
                "        {'id':'word-input', 'name':'0数据导入', 'target':'navtab', 'url':'html/form/wordinput.html'}," +
                "        {'id':'img-nput', 'name':'0影像数据导入', 'target':'navtab', 'url':'html/form/imginput.html'}," +
//                "        {'id':'img-view', 'name':'文本数据详细', 'target':'navtab', 'url':'html/form/wordview.html'}," +
                "    ]}," +
                "    {'name':'0数据中心', 'children':[" +
                "        {'id':'wordsearch', 'name':'0数据检索', 'target':'navtab', 'url':'html/form/wordsearch.html'}" +
                "        {'id':'imgsearch', 'name':'0数据下载', 'target':'navtab', 'url':'html/form/imgsearch.html'}" +
                "    ]}" +
                "    {'name':'0配置中心', 'children':[" +
                "        {'id':'wordsearch', 'name':'0站点配置', 'target':'navtab', 'url':'html/form/wordsearch.html'}" +
                "        {'id':'imgsearch', 'name':'0用户配置', 'target':'navtab', 'url':'html/form/imgsearch.html'}" +
                "    ]}" +
                "    {'name':'0分析统计', 'children':[" +
                "        {'id':'wordsearch', 'name':'0数据总览', 'target':'navtab', 'url':'html/form/wordsearch.html'}" +
                "        {'id':'imgsearch', 'name':'0数据明细', 'target':'navtab', 'url':'html/form/imgsearch.html'}" +
                "    ]}" +
//                "    {'name':'日志管理','children':[" +
//                "    {'id':'user-tree', 'name':'日志管理', 'target':'navtab', 'url':'html/form/user-tree.html'}" +
//                "    ]}" +


                "    {'name':'1智能导入', 'children':[" +
                "        {'id':'data-input', 'name':'1数据导入', 'target':'navtab', 'url':'html/form/import/dir-import.html'}," +
                "        {'id':'img-nput', 'name':'1影像数据导入', 'target':'navtab', 'url':'html/form/imginput.html'}," +
                "    ]}," +
                "    {'name':'1数据中心', 'children':[" +
                "        {'id':'wordsearch', 'name':'1数据检索', 'target':'navtab', 'url':'html/form/search/advanced-search-img.html'}" +
                "        {'id':'imgsearch', 'name':'1数据下载', 'target':'navtab', 'url':'html/form/imgsearch.html'}" +
                "    ]}" +
                "    {'name':'1配置中心', 'children':[" +
                "        {'id':'serversetting', 'name':'1文件站点中心', 'target':'navtab', 'url':'html/form/setting/fileserver-search.html'}" +
                "        {'id':'usersetting', 'name':'1用户中心', 'target':'navtab', 'url':'html/form/setting/user-search.html'}" +
                "    ]}" +
                "    {'name':'1分析统计', 'children':[" +
                "        {'id':'wordsearch', 'name':'1数据总览', 'target':'navtab', 'url':'html/form/wordsearch.html'}" +
                "        {'id':'imgsearch', 'name':'1数据明细', 'target':'navtab', 'url':'html/form/imgsearch.html'}" +
                "    ]}" +


                "]");

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/user-tree")
    public JSONArray userTree() throws IOException {
        JSONArray jsonObject = JSONArray.parseArray("["+
               " {'id':'super','department':null,'level':0,'order':0,'name':'超级管理员','parentid':null},"+
                "{'id':'2018a','department':'001','level':1,'order':0,'name':'管理员','parentid':'super'}"+
                "{'id':'2018a0','department':'001','level':2,'order':0,'name':'Debbie','parentid':'2018a'},"+
                "{'id':'2018b','department':'002','level':1,'order':0,'name':'普通用户','parentid':'super'}"+
                "{'id':'2018b0','department':'002','level':2,'order':0,'name':'Jack','parentid':'2018b'},"+
       "]");
        return jsonObject;
    }
    @RequestMapping("/test")
    public String function(){

        return "login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/role")
    public String role(){

        return "login";
    }




    //获取验证码图片
    @RequestMapping("/getKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @ResponseBody
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public ModelAndView imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView andView = new ModelAndView();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);

        if (!captchaId.equals(parameter)) {
            andView.addObject("info", "错误的验证码");
            andView.setViewName("index");
        } else {
            andView.addObject("info", "登录成功");
            andView.setViewName("succeed");

        }
        return andView;
    }




}



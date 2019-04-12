package com.bit.armdcrf.controller;

import com.bit.armdcrf.entity.Fileserver;
import com.bit.armdcrf.service.Impl.fileServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "server")
public class ServerController {

  @Autowired
  fileServerServiceImpl fileServerService;

  @RequestMapping(value = "addserver",method = RequestMethod.POST)
  public Map<String,String> addserver(@RequestParam("servername") String servername,
                        @RequestParam("serverip") String serverip,
                        @RequestParam("serverport") String serverport){
    System.out.println("~~~~~~" + servername + "：" + serverip+ ":" + serverport +"~~~~~~~~");
    Map<String,String> result = new HashMap<String, String>();
    if (StringUtils.isEmpty(servername)){
      servername = "文件服务器";
    }
    if(!fileServerService.judgeIP(serverip)){
      result.put("result", "failure");
      result.put("mess", "文件服务器ip不合法");
      return result;
    }else if (fileServerService.getByIp(serverip)!=null){
      result.put("result", "failure");
      result.put("mess", "文件服务器已存在，请勿重复添加！");
      return result;
    }
    Fileserver fileserver = new Fileserver();
    fileserver.setName(servername);
    fileserver.setIp(serverip);
    fileserver.setPort(Integer.parseInt(serverport));
    if (fileServerService.addFileServer(fileserver)){
      result.put("result", "success");
      result.put("mess", "文件服务器添加成功");
      return result;
    }else{
      result.put("result", "failure");
      result.put("mess", "未知错误");
      return result;
    }

  }

}

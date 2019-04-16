package com.bit.armdcrf.controller;

import com.bit.armdcrf.exception.FTPErrors;
import com.bit.armdcrf.service.ftpClient.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("FTP")
public class FTPController {
  @Autowired
  private FTPService ftpService;

  @RequestMapping( value = "/test/upload", method = RequestMethod.GET)
  public void uploadExample(){
    try {

      ftpService.connectToFTP("10.55.223.210","anonymous","a");
      ftpService.uploadFileToFTP(new File("/Users/jjmeg/Documents/毕设/testData/说明文档.yaml"),"/images","说明文档.yaml");
      ftpService.downloadFileFromFTP("/foto.png","/Users/jjmeg/Documents/毕设/images/kaka.png");

    } catch (FTPErrors ftpErrors) {
      System.out.println(ftpErrors.getMessage());
    }
  }

  @RequestMapping( value = "/test/dir/upload", method = RequestMethod.GET)
  public void uploadDirExample(){
    try {

      ftpService.connectToFTP("10.55.223.210","anonymous","a");

      ftpService.uploadDirToFTP(new File("/Users/jjmeg/Documents/毕设/testData"),"/eee/fff");

    } catch (FTPErrors ftpErrors) {
      System.out.println(ftpErrors.getMessage());
    }
  }

  @RequestMapping(value="import",method = RequestMethod.POST)
  public Map<String,String> importFile(@RequestParam("file.uri") String uri, @RequestParam("file.toDir") String serverDir){



    Map<String,String> result = new HashMap<String, String>();
    if(true) {
      result.put("result", "success");
      result.put("mess", "导入成功");
    }
    else{
      result.put("result", "fail");
      result.put("mess", "导入失败，请联系管理员！");
    }

    return result;
  }

}

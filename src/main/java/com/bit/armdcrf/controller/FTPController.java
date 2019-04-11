package com.bit.armdcrf.controller;

import com.bit.armdcrf.exception.FTPErrors;
import com.bit.armdcrf.service.ftpClient.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("FTP")
public class FTPController {
  @Autowired
  private FTPService ftpService;

  @RequestMapping( value = "/test/upload", method = RequestMethod.GET)
  public void uploadExample(){
    try {

      ftpService.connectToFTP("10.55.223.210","anonymous","a");
      ftpService.uploadFileToFTP(new File("/Users/jjmeg/Documents/毕设/images/logo.png"),"/","foto.png");
      ftpService.downloadFileFromFTP("/foto.png","/Users/jjmeg/Documents/毕设/images/kaka.png");

    } catch (FTPErrors ftpErrors) {
      System.out.println(ftpErrors.getMessage());
    }
  }

}
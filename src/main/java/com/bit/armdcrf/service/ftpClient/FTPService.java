package com.bit.armdcrf.service.ftpClient;

import com.bit.armdcrf.exception.FTPErrors;
import java.io.File;

public interface FTPService {
  void connectToFTP(String host, String user, String pass) throws FTPErrors;
  void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;
  void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
  void disconnectFTP() throws FTPErrors;

  void uploadDirToFTP(File dir, String ftpHostDir) throws FTPErrors;

  void downloadDirFromFTP(String serverDir,String copytoPath) throws FTPErrors;

}

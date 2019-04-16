package com.bit.armdcrf.service.ftpClient;

import com.bit.armdcrf.exception.ErrorMessage;
import com.bit.armdcrf.exception.FTPErrors;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class FTPServiceImpl implements FTPService {
  /**
   * FTP connection handler
   */
  FTPClient ftpconnection;

  private static Logger logger = Logger.getLogger(FTPServiceImpl.class.getName());

  /**
   * Method that implement FTP connection.
   *
   * @param host IP of FTP server
   * @param user FTP valid user
   * @param pass FTP valid pass for user
   * @throws FTPErrors Set of possible errors associated with connection process.
   */
  @Override
  public void connectToFTP(String host, String user, String pass) throws FTPErrors {

    ftpconnection = new FTPClient();
    ftpconnection.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    int reply;

    try {
      ftpconnection.connect(host);
    } catch (IOException e) {
      ErrorMessage errorMessage = new ErrorMessage(-1, "\n" +
              "It was not possible to connect to FTP through the host =" + host);
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }

    reply = ftpconnection.getReplyCode();

    if (!FTPReply.isPositiveCompletion(reply)) {

      try {
        ftpconnection.disconnect();
      } catch (IOException e) {
        ErrorMessage errorMessage = new ErrorMessage(-2,
                "It was not possible to connect to FTP, the host = " + host + " delivered the answer =" + reply);
        logger.info(errorMessage.toString());
        throw new FTPErrors(errorMessage);
      }
    }

    try {
      ftpconnection.login(user, pass);
    } catch (IOException e) {
      ErrorMessage errorMessage = new ErrorMessage(-3, "The user = " + user + ", and pass = "
              + pass + " were not valid for authentication.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }

    try {
      ftpconnection.setFileType(FTP.BINARY_FILE_TYPE);
    } catch (IOException e) {
      ErrorMessage errorMessage = new ErrorMessage(-4,
              "The data type for the transfer is not valid.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }

    ftpconnection.enterLocalPassiveMode();
  }

  /**
   * Method that allow upload file to FTP
   *
   * @param file           File object of file to upload
   * @param ftpHostDir     FTP host internal directory to save file
   * @param serverFilename Name to put the file in FTP server.
   * @throws FTPErrors Set of possible errors associated with upload process.
   */
  @Override
  public void uploadFileToFTP(File file, String ftpHostDir, String serverFilename) throws FTPErrors {
    if(!ftpHostDir.endsWith("/")){
      ftpHostDir = ftpHostDir + "/";
    }
    try {
      InputStream input = new FileInputStream(file);
      this.ftpconnection.storeFile(ftpHostDir + serverFilename, input);
    } catch (IOException e) {
      ErrorMessage errorMessage = new ErrorMessage(-5, "The file could not be uploaded to the server.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }

  }

  /**
   * Method for download files from FTP.
   *
   * @param ftpRelativePath Relative path of file to download into FTP server.
   * @param copytoPath      Path to copy the file in download process.
   * @throws FTPErrors Set of errors associated with download process.
   */

  @Override
  public void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors {

    FileOutputStream fos;
    try {
      fos = new FileOutputStream(copytoPath);
    } catch (FileNotFoundException e) {
      ErrorMessage errorMessage = new ErrorMessage(-6,
              "Could not get the reference to the relative folder to save, verify the path and permissions.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }

    try {
      this.ftpconnection.retrieveFile(ftpRelativePath, fos);
    } catch (IOException e) {
      ErrorMessage errorMessage = new ErrorMessage(-7, "The file could not be downloaded.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }
  }

  /**
   * Method for release the FTP connection.
   *
   * @throws FTPErrors Error if unplugged process failed.
   */
  @Override
  public void disconnectFTP() throws FTPErrors {
    if (this.ftpconnection.isConnected()) {
      try {
        this.ftpconnection.logout();
        this.ftpconnection.disconnect();
      } catch (IOException f) {
        throw new FTPErrors(new ErrorMessage(-8,
                "An error occurred when disconnecting the FTP server"));
      }
    }
  }

  @Override
  public void uploadDirToFTP(File dir, String ftpHostDir) throws FTPErrors {
    try {
      if(!ftpHostDir.endsWith("/")){
        ftpHostDir = ftpHostDir + "/";
      }
      System.out.println("本次上传到服务器文件夹： " + ftpHostDir);
      String[] files = dir.list();
      if (checkDirExists(ftpHostDir)) {
        for (String serverFilename : files) {
          //System.out.println(serverFilename);
          System.out.println("准备上传： " + dir.getPath() + "/" + serverFilename);
          File toInput = new File(dir.getPath() + "/" + serverFilename);
          if (toInput.isDirectory()) {
            System.out.println("-----------------" + "subDir upload to " + ftpHostDir + serverFilename);
            uploadDirToFTP(toInput, ftpHostDir + serverFilename);
            continue;
          }
          InputStream input = new FileInputStream(toInput);
          System.out.println("single file upload" + dir.getPath() + "/" + serverFilename);
          this.ftpconnection.storeFile(ftpHostDir + serverFilename, input);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      ErrorMessage errorMessage = new ErrorMessage(-5, "The file could not be uploaded to the server.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    } catch (IOException e) {
      e.printStackTrace();
      ErrorMessage errorMessage = new ErrorMessage(-5, "The file could not be uploaded to the server.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }
  }

  @Override
  public void downloadDirFromFTP(String serverDir, String copytoPath) throws FTPErrors {
    try {
      ArrayList<String> fileList = getRemoteDirList(serverDir);
      for (String file :fileList){
        System.out.println("准备下载： " + file);
        downloadFileFromFTP(serverDir + file, copytoPath);
        System.out.println("下载： " + file + "完毕");
      }
    }catch (IOException e){
      e.printStackTrace();
      ErrorMessage errorMessage = new ErrorMessage(-5, "Get the remote directory filename list error.");
      logger.info(errorMessage.toString());
      throw new FTPErrors(errorMessage);
    }
  }

  private boolean checkDirExists(String ftpHostDir) throws IOException {
    try {
      //不存在此目录
      if (!changeWorkingDirectory(ftpHostDir)) {
        //则递归创建
        return makeDirRecurse(ftpHostDir);
      } else {
        return true;
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    return false;
  }

  private boolean changeWorkingDirectory(String dir) {
    boolean flag = true;
    try {
      flag = this.ftpconnection.changeWorkingDirectory(dir);
      if (flag) {
        System.out.println("进入文件服务器文件夹" + dir + " 成功！");
      } else {
        System.out.println("进入文件服务器文件夹" + dir + " 失败！");
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return flag;
  }

  private boolean makeDirRecurse(String dir) throws IOException {
    int start = 0;
    int end = 0;
    if (dir.startsWith("/")) {
      start = 1;
    } else {
      start = 0;
    }
    end = dir.indexOf("/", start);
    String path = "";
    String paths = "";
    while (true) {

      String subDirectory = new String(dir.substring(start, end).getBytes("GBK"), "iso-8859-1");
      path = path + "/" + subDirectory;
      if (!existFile(path)) {
        if (makeDirectory(subDirectory)) {
          changeWorkingDirectory(subDirectory);
        } else {
          System.out.println("创建目录[" + subDirectory + "]失败");
          changeWorkingDirectory(subDirectory);
        }
      } else {
        changeWorkingDirectory(subDirectory);
      }

      paths = paths + "/" + subDirectory;
      start = end + 1;
      end = dir.indexOf("/", start);
      // 检查所有目录是否创建完毕
      if (end <= start) {
        break;
      }
    }
    return true;
  }

  private boolean makeDirectory(String dir) {
    boolean flag = true;
    try {
      flag = this.ftpconnection.makeDirectory(dir);
      if (flag) {
        System.out.println("创建服务器文件夹" + dir + " 成功！");
      } else {
        System.out.println("创建服务器文件夹" + dir + " 失败！");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  private boolean existFile(String path) throws IOException {
    boolean flag = false;
    FTPFile[] ftpFileArr = this.ftpconnection.listFiles(path);
    if (ftpFileArr.length > 0) {
      flag = true;
    }
    return flag;
  }

//  private static class FilterFilesVisitor extends SimpleFileVisitor<Path> {
////    private List<String> result = new LinkedList<String>();
////
////    public FilterFilesVisitor(List<String> result) {
////      this.result = result;
////    }
////
////    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
////      result.add(file.toString());
////      return FileVisitResult.CONTINUE;
////    }
////  }

  private ArrayList<String> getRemoteDirList(String serverDir) throws IOException{
    ArrayList<String> result = new ArrayList<>();
    FTPFile[] ftpFileArr = this.ftpconnection.listFiles(serverDir);
    if (ftpFileArr.length>0){
      for (FTPFile file : ftpFileArr){
        result.add(file.getName());
      }
    }
    return result;
  }

}

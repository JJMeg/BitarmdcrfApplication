package com.bit.armdcrf.image;
//import ij.plugin.DICOM;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *  @author Debbie Qiu
 * dicom文件java解析，生成图片
 * 不过这里不能解析压缩的dicom文件
 */
public class Dcm2jpeg {

    public static void main(String args[]) {

        //create("/Users/Debbie/Documents/DM/AllDICOMs/20587372_e634830794f5c1bd_MG_L_ML_ANON.dcm");   //在电脑dicom文件夹下生成test1.dcm.jpg图片文件

    }



    /**
     * 输入一个dicom文件的绝对路径和名字
     * 获取一个jpg文件
     */
    public void create(String filePath,String sPath) {
        try {
//            DICOM dicom = new DICOM();
//            dicom.run(filePath);
//            BufferedImage bi = (BufferedImage) dicom.getImage();
//            int width = bi.getWidth();
//            int height = dicom.getHeight();
//            System.out.println("width: " + width + "\n" + "height: " + height);
//            ImageIO.write(bi, "jpg", new File(sPath));


        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
        }

    }


}


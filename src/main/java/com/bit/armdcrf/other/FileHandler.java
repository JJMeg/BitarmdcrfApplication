package com.bit.armdcrf.other;

import java.io.*;

/**
 * @author Debbie Qiu
 */
public class FileHandler {

    public static String read(String path){
        File f = new File(path);
        String temp = "";
        String content = "";
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            while ((temp = reader.readLine()) != null) {
                content += temp + ",";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }
}

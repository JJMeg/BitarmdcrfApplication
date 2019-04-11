package com.bit.armdcrf;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Debbie Qiu
 */
public class uriTest {

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("file://Users/Debbie/Desktop/CRF/CRF");
        //File file = new Path(url.getPath()).toFile();
        Path path = Paths.get(url.getPath());

    }

    @Test
    public void testJson(){
        List<String> uris = new ArrayList<>();
        uris.add("1");
        uris.add("2");
        uris.add("3");

        String s="{Hash:'1996461318', id:'10', hospitalid:'123456', patientid:'1', patientname:'debbie'}";
        JSONObject jsonImg = JSONObject.parseObject(s);


        System.out.print(uris.toString());
    }


    @Test
    public void testUri(){
        //URL url = uriTest.class.getResource("/static/imgaes/logo.png");
        String fileName = this.getClass().getClassLoader().getResource("userDict.txt").getPath();//获取文件路径
        System.out.print(fileName);
    }

}

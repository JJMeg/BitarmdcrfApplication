package com.bit.armdcrf.service.DataHandler;

import com.bit.armdcrf.dao.ImgdataMapper;
import com.bit.armdcrf.dto.ImgData;
import com.bit.armdcrf.dto.SearchData;
import com.bit.armdcrf.entity.Crf.Crf;
import com.bit.armdcrf.image.Dcm2jpeg;
import com.bit.armdcrf.model.Imgdata;
import com.bit.armdcrf.other.FileHandler;
import com.bit.armdcrf.service.Interface.ImgDataHandler;
import com.bit.armdcrf.service.Interface.WordDataAcquire;
import com.bit.armdcrf.service.Interface.WordDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * @author Debbie Qiu
 */
@Component
public class ImgDataHandlerImpl implements ImgDataHandler{
    @Autowired
    ImgdataMapper imgdataMapper;
    @Autowired
    WordDataHandler wordDataHandler;

    String rootDir = this.getClass().getClassLoader().
            getResource("application.properties").getPath()
            .replace("application.properties","")+"static/images/";



    @Override
    public List<ImgData> search(SearchData searchData) {
        List<String> ids = wordDataHandler.searchWordId(searchData);
        List<Imgdata> imgdata = new LinkedList<>();
        List<ImgData> imgData = new LinkedList<>();
        for(String id:ids){
            imgdata = imgdataMapper.selectByPatientid(id);
            imgData.addAll(toGroup(imgdata));

        }
        return imgData;
    }

    @Override
    public List<String> add(String uri) {
        List<String> failFile  = new ArrayList<>();

        try {

            URI url = new URI(uri);
            Files.walkFileTree(Paths.get(url.getSchemeSpecificPart()), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                    System.out.println("正在访问：" + dir + "目录");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(!file.getFileName().toString().endsWith(".dcm"))
                        return FileVisitResult.CONTINUE;
                    String fileName = file.getFileName().toString();
                    System.out.println("\t正在访问" + fileName + "文件");

                    if (fileName.endsWith(".dcm") && !fileName.startsWith("~")) {
                        String txtPath = file.toString().substring(0,file.toString().length()-4)+".txt";
                        if(new File(txtPath).exists()){
                            Imgdata imgdata = new Imgdata();
                            imgdata = getData(FileHandler.read(txtPath));
                            imgdata.setUri("file:/" + file.toString());
                            imgdataMapper.insert(imgdata);
                        }
                        else{
                            failFile.add(file.toString());
                            return FileVisitResult.CONTINUE;
                        }

                    }
                    else
                        return FileVisitResult.CONTINUE;

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return failFile;
    }

    @Override
    public int delete(String id, boolean diskClean) {
        return 0;
    }

    @Override
    public int update(Imgdata imgdata) {
        return 0;
    }

    @Override
    public int addSingle(Imgdata imgdata) {
        imgdataMapper.insert(imgdata);
        return 0;
    }

    @Override
    public int move(String fileUrl, String aimPath) {
        return 0;
    }

    @Override
    public List<String> viewImg(String uris) {
        List<String> result = new LinkedList<>();
        String[] us = uris.substring(1,uris.length()-1).split(",");
        Dcm2jpeg dcm2jpeg =  new Dcm2jpeg();

        try {
            for(String uri:us) {

                URI url = new URI(uri.trim());
                String filePath = url.getSchemeSpecificPart();
                Path file = Paths.get(filePath);
                String fileName = file.getFileName().toString();

                String sPath = rootDir + fileName+".jpg";
                String htmlPath = "/images/"+fileName+".jpg";

                dcm2jpeg.create(filePath,sPath);
                result.add(htmlPath);

            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public String viewVideo(String uris) {


        String[] temp= uris.substring(1,uris.length()-1).split("/");
        String filename = temp[temp.length-1];
        String sFile = rootDir+filename;
        OutputStream stream = null;

        try {
            stream = new FileOutputStream(new File(sFile));
            URI url = new URI(uris.substring(1,uris.length()-1));
            Files.copy(Paths.get(url.getSchemeSpecificPart()),stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String htmlPath = "/images/"+filename;
        return htmlPath;
    }




    public Imgdata getData(String mess){
        Imgdata imgdata = new Imgdata();

        for(String t:mess.split(","))
        {
            String[] kv = t.split(":");
            if(kv.length == 2)
            if(kv[0].equals("patientid"))
                imgdata.setPatientid(kv[1]);
            else if(kv[0].equals("hospitalid"))
                imgdata.setHospitalid(kv[1]);
            else if(kv[0].equals("patientname"))
                imgdata.setPatientname(kv[1]);
            else if(kv[0].equals("patientsex"))
                imgdata.setPatientsex(kv[1]);
            else if(kv[0].equals("studystage"))
                imgdata.setStudystage(kv[1]);
            else if(kv[0].equals("importdate"))
                imgdata.setImportdate(kv[1]);
            else if(kv[0].equals("datatype"))
                imgdata.setDatatype(kv[1]);
            else if(kv[0].equals("studytype"))
                imgdata.setStudytype(kv[1]);
        }

        return imgdata;

    }



    public List<ImgData> toGroup(List<Imgdata> imgdata){
        List<ImgData> imgData = new LinkedList<>();
        Map<String, List<Imgdata>> resultMap = new HashMap<String, List<Imgdata>>();
        //将同一个序列的图像分到同组
        for(Imgdata img : imgdata){
            String[] temp = img.getUri().split("/");

            String series = temp[temp.length-1];
            temp = series.split("\\.");  //TODO:根据测试集进行一定的修改
            series = temp[0];


            if(resultMap.containsKey(series)){
                resultMap.get(series).add(img);
            }else{//map中不存在，新建key，用来存放数据
                List<Imgdata> tmpList = new ArrayList<Imgdata>();
                tmpList.add(img);
                resultMap.put(series,tmpList);
            }
        }
        //将每组URI排序并放入新的ImgData对象中
        for(Map.Entry<String,List<Imgdata>> entry:resultMap.entrySet()){
            List<Imgdata> temp = entry.getValue();
             Collections.sort(temp, new Comparator<Imgdata>(){
                public int compare(Imgdata o1, Imgdata o2) {
                    if(o1.getUri().compareTo(o2.getUri())>0){
                        return 1;
                    }
                    if(o1.getUri().compareTo(o2.getUri()) == 0){
                        return 0;
                    }
                    else
                        return -1;
                }
            });



            ImgData iData = new ImgData();

            iData.setImgdata(imgdata.get(0));

            List<String> uris = new LinkedList<>();
            for(Imgdata t:temp){
                uris.add(t.getUri());
            }
            iData.setUris(uris);

            imgData.add(iData);
        }



        return  imgData;

    }




}

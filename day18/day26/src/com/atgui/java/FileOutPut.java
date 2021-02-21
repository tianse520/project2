package com.atgui.java;

import org.junit.Test;

import java.io.*;

/**
 * @author tianse
 */
/*
对图片进行复制
 */
public class FileOutPut {

    @Test
    public void testinpu() {


        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("school.jpg");
            File destfile = new File("school1.jpg");

            //
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //复制过程
            byte[] buffer =  new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }




    }

    //指定位置文件的复制
    public void copyFile(String srcFile, String destFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File(srcFile);
            File destfile = new File(destFile);

            //
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //复制过程
            byte[] buffer =  new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }





    }

    //测试方法copyFile
    @Test
    public void copyFiletest(){
        long start = System.currentTimeMillis();
        String srcPath = "F:\\BaiduNetdiskDownload\\1.avi";
        String destPath = "F:\\BaiduNetdiskDownload\\2.avi";
        copyFile(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作时间：" + (end -start));//2470

    }
}

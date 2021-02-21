package com.atgui.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取，写入速度
 * 提高读写速度的原因：内部存在一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上
 * @author tianse
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("school.jpg");
            File destFile = new File("school3.jpg");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream((srcFile));
            fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3、复制的细节：读取，写入
            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            //关闭外层流的同时，内存流也会自动的进行关闭。关于内层流的管可以省略
//            fos.close();
//            fis.close();

        }

    }
    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath) {


        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
           FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3、复制的细节：读取，写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    @Test
    public void testCopyFileWithBuffered(){

            long start = System.currentTimeMillis();
            String srcPath = "F:\\BaiduNetdiskDownload\\1.avi";
            String destPath = "F:\\BaiduNetdiskDownload\\3.avi";
            copyFileWithBuffered(srcPath,destPath);


            long end = System.currentTimeMillis();

            System.out.println("复制操作时间：" + (end -start));//747


    }
    //使用BufferedReader和BufferedWriter实现文本文件的复制
    @Test
    public  void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));


            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf, 0 ,len);
//            }
            //方式二：使用String
           String data;
           while((data = br.readLine()) != null){
// 方法1.              bw.write(data + "\n");//data种不包含换行符
           //方法2.
               bw.write(data);
               bw.newLine();//提供换行的操作
           }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

package at.guigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
 * @author tianse
 */
public class TCPTest3 {

    @Test
    public void client() throws IOException {
        //1
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
        //2
        OutputStream os = socket.getOutputStream();
        //3
        FileInputStream fis = new FileInputStream(new File("school.jpg"));
        //4
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //关闭数据输出
        socket.shutdownOutput();

        //5接收服务器端数据，并显示
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while((len1 = is.read(bufferr)) != -1){
            baos.write(bufferr,0,len1);
        }
        System.out.println(baos.toString());

        //6
        fis.close();
        os.close();
        socket.close();
        baos.close();

    }

    @Test
    public void server() throws IOException {
        //1
        ServerSocket ss= new ServerSocket(8899);
        //2
        Socket socket = ss.accept();
        //3
        InputStream is = socket.getInputStream();
        //4
        FileOutputStream fos = new FileOutputStream(new File("school6.jpg"));
        //5
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完成");

        //6
        OutputStream os = socket.getOutputStream();
        os.write("照片收到,很漂亮".getBytes());
        //7
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}

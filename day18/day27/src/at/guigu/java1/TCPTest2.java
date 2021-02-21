package at.guigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：.客户端发送文件给服务端，服务端将文件保存在本地。
 * @author tianse
 */
public class TCPTest2 {

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
        //5
        fis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        //
        ServerSocket ss= new ServerSocket(8899);
        //
       Socket socket = ss.accept();
        //
        InputStream is = socket.getInputStream();
        //
        FileOutputStream fos = new FileOutputStream(new File("school5.jpg"));
        //
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}

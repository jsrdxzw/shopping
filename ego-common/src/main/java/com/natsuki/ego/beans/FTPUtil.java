package com.natsuki.ego.beans;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: ftp工具类
 */
public class FTPUtil {
    public static void main(String[] args) {
        String hostname = "39.105.15.234";
        int port = 21;
        String username = "ftpuser";
        String password = "xzw101065";
        String pathname = "/home/ftpuser/jd";
        String remote = "demo2.jpg";
        InputStream local = null;
//        uploadFile(hostname, port, username, password, pathname, remote,local);
    }

    public static boolean uploadFile(String hostname, int port, String username, String password, String pathname, String remote,InputStream inputStream) {
        boolean flag = false;
        //创建ftpClient对象
        FTPClient ftpClient = new FTPClient();
        try {
            //建立连接
            ftpClient.connect(hostname, port);
            //登录
            ftpClient.login(username, password);
            //设置上传文件的类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //切换工作目录,文件上传保存目录
            if (!ftpClient.changeWorkingDirectory(pathname)) {
                if (ftpClient.makeDirectory(pathname)) {
                    ftpClient.changeWorkingDirectory(pathname);
                }
            }
            //实现文件上传
            ftpClient.storeFile(remote,inputStream);
            inputStream.close();
            ftpClient.logout();
            ftpClient.disconnect();
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

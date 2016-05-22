package com.longchao.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/15.
 */
public class ProxyClassFile {

    public static void main(String[] args) {

        String proxyName = "UserServiceProxy";

        UserService a = new UserServiceImpl();
        Class[] interfaces = a.getClass().getInterfaces();
        byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, interfaces);
        File f = new File("D:/work/code/middleware/study/proxy/UserServiceProxy.class");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}

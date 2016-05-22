package com.longchao.agent;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/18.
 */
public class CustomAgent implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new CustomAgent());
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.startsWith("java") && !className.startsWith("sun")) {
            // �Ȳ���javaҲ����sun��ͷ��
            // ��������
            int lastIndexOf = className.lastIndexOf("/") + 1;
            String fileName = className.substring(lastIndexOf) + ".class";
            exportClazzToFile("d:/aop/", fileName, classfileBuffer);
            System.out.println(className + " --> EXPORTED Succeess!");
        }
        return classfileBuffer;
    }

    /**
     * @param dirPath  Ŀ¼��/��β���ұ������
     * @param fileName
     * @param data
     */
    private void exportClazzToFile(String dirPath, String fileName, byte[] data) {
        try {
            File file = new File(dirPath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            System.out.println("exception occured while doing some file operation");
            e.printStackTrace();
        }
    }
}

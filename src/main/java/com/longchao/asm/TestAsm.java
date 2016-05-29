package com.longchao.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/24.
 */
public class TestAsm {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com.longchao.asm.TestClass");
        ClassWriter classWriter = new ClassWriter(classReader, 0);
        ClassVisitor classVisitor = new ProgrammerClassAdapter(classWriter);
        classReader.accept(classVisitor, 0);

    }
}

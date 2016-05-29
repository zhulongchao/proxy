package com.longchao.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/24.
 */
public class ProgrammerClassAdapter  extends ClassAdapter{
    public ProgrammerClassAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }
    public MethodVisitor visitMethod(int access,String name,String desc,String signature,String[] exceptions){
        MethodVisitor methodVisitor = cv.visitMethod(access,name,desc,signature,exceptions);
        if(null != methodVisitor&& "doCoding".equals(name)){
            methodVisitor = new DoCodingMethodAdapter(methodVisitor);
            return methodVisitor;

        }
        return methodVisitor;
    }
}

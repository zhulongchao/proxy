package com.longchao.asm;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/24.
 */
public class DoCodingMethodAdapter extends MethodAdapter {

    public DoCodingMethodAdapter(MethodVisitor arg0){
        super(arg0);
    }

    public void visitCode(){
        super.visitCode();
        mv.visitFieldInsn(Opcodes.GETSTATIC,"System","out","Ljava/io/PrintStream");
        mv.visitLdcInsn("doAsmCode............");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V");

    }



}

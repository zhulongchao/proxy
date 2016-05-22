package com.longchao.cglib;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/19.
 */
public class MyMethodIntercepter implements MethodInterceptor{
    Object trueObject;
    public MyMethodIntercepter(Object obj){
        this.trueObject = obj;

    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("brfore cglib invoke");
        Object result = method.invoke(trueObject, args);
        System.out.println("after cglib invoke");
        return result;
    }
}

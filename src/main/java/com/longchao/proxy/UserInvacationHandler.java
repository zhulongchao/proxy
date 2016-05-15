package com.longchao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/15.
 */
public class UserInvacationHandler implements InvocationHandler {

    private Object target;
     public Object getProxyInstance(Object target){
         this.target =target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("before target method.....");
        result = method.invoke(target,args);
        System.out.println("after target method.....");
        return result;
    }
}

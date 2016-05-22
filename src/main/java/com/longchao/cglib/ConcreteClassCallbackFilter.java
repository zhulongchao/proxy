package com.longchao.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/19.
 */
public class ConcreteClassCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("create")){
            return 1;
        }
        return 0;
    }
}

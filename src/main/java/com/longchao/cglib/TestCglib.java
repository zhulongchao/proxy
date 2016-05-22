package com.longchao.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/19.
 */
public class TestCglib {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
       /* CrudService service = new CrudServiceImpl();
        MethodInterceptor interceptor = new MyMethodIntercepter(service);
        enhancer.setCallback(interceptor);
         CrudService proxy = (CrudService)enhancer.create(CrudService.class, interceptor);
        System.out.println("proxy class name>>>>>"+proxy.getClass().getName());
        System.out.println(proxy.create("ddd"));*/

        enhancer.setSuperclass(CrudServiceImpl.class);
        //enhancer.setCallback(new MyMethodIntercepter1());
        enhancer.setCallbacks(new Callback[]{NoOp.INSTANCE,new MyMethodIntercepter1()});
        enhancer.setCallbackFilter(new ConcreteClassCallbackFilter());
        //enhancer.setUseFactory(false);
        CrudService proxy = (CrudService)enhancer.create();
        System.out.println("proxy class name>>>>>"+proxy.getClass().getName());
        System.out.println(proxy.create("ddd"));
        System.out.println("==============================");
        System.out.println(proxy.delete(1L));


    }
}

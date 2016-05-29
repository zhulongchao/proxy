package com.longchao.proxy.bean;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/26.
 */
public class TestBeanWrapper {
    public static void main(String[] args){
        BeanWrapper companyWrapper = new BeanWrapperImpl(new Company());
        companyWrapper.setPropertyValue("name","alibaba-inc...");
        PropertyValue cname = new PropertyValue("name","taobao....");
        companyWrapper.setPropertyValue(cname);

        BeanWrapper employWrapper = new BeanWrapperImpl(new Employee());
        employWrapper.setPropertyValue("name","chuanqing");
        companyWrapper.setPropertyValue("manager",employWrapper.getWrappedInstance());

        Float salary = (Float) companyWrapper.getPropertyValue("manager.salary");

        String name = (String)companyWrapper.getPropertyValue("manager.name");
        System.out.println(name);

    }
}

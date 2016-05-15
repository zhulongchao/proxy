package com.longchao.proxy;

/**
 * <p>
 * </p>
 *
 * @author chuan.qing(zhu.longchao)
 * @version 1.0
 * @create 2016/5/15.
 */
public class ProxyTest {
    public static void main(String[] args){
        UserInvacationHandler userInvacationHandler = new UserInvacationHandler();
        UserService userService = (UserService) userInvacationHandler.getProxyInstance(new UserServiceImpl());
        userService.addUser(1L);
    }
}

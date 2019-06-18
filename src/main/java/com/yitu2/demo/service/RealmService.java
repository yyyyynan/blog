package com.yitu2.demo.service;

/**
 * @author Administrator
 */
public interface RealmService {

    /**
     *  检查数据库中是否存在该用户名
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 根据用户名获取密码
     * 此函数有待加强操作
     * @param username
     * @return
     */
    String getPasswordByUsername(String username);

    /**
     * 根据用户名获取权限
     * @param username
     * @return
     */
    String getPermByName(String username);
}

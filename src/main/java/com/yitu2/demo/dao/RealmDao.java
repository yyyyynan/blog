package com.yitu2.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 */
public interface RealmDao {

    /**
     *  检查数据库中是否存在该用户名
     * @param username
     * @return
     */
    @Select("SELECT count(id) FROM `admin` where username = #{username}")
    int checkUsername(@Param("username") String username);

    /**
     * 根据用户名获取密码
     * @param username
     * @return
     */
    @Select("SELECT password FROM `admin` where username = #{username}")
    String getPasswordByUsername(@Param("username") String username);

    /**
     * 根据用户名获取权限
     * @param username
     * @return
     */
    @Select("SELECT perm FROM `admin` where username = #{username}")
    String getPermByName(String username);
}

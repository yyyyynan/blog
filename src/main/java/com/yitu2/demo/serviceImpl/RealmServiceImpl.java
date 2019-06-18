package com.yitu2.demo.serviceImpl;

import com.yitu2.demo.dao.RealmDao;
import com.yitu2.demo.service.RealmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service("RealmService")
public class RealmServiceImpl implements RealmService {
    @Resource
    private RealmDao realmDao;

    /**
     *  检查数据库中是否存在该用户名
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        if (realmDao.checkUsername(username) == 1){
            return true;
        }
        System.out.println(realmDao.checkUsername(username));
        return false;
    }

    /**
     * 根据用户名获取密码
     * @param username
     * @return
     */
    @Override
    public String getPasswordByUsername(String username) {
        return realmDao.getPasswordByUsername(username);
    }

    /**
     * 根据用户名获取权限
     * @param username
     * @return
     */
    @Override
    public String getPermByName(String username) {
        return realmDao.getPermByName(username);
    }
}

package com.yitu2.demo.service;

import com.yitu2.demo.model.indexmodel.HomepageRaiders;
import com.yitu2.demo.model.indexmodel.homepageADmodel;
import com.yitu2.demo.model.indexmodel.homepageActivityModel;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
public interface MainService {
    /**
     * 获取首页广告列表
     * @return
     */
    List<homepageADmodel> listHomepageAD();

    /**
     * 获取首页同城活动
     * @return
     */
    List<homepageActivityModel> listHomepageActivity();

    /**
     * 获取首页查攻略
     * @return
     */
    List<HomepageRaiders> listHomepageRaiders();

    /**
     * 添加测试
     * @param par
     * @param session
     * @return
     */
    int addtest(String par, HttpSession session);

    /**
     * 多线程减去商品测试
     * @return
     */
    int selvaltest();

    /**
     * 商品恢复数量 200
     * @return
     */
    void addth();
}

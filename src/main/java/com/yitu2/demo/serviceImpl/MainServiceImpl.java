package com.yitu2.demo.serviceImpl;

import com.yitu2.demo.dao.MainDao;
import com.yitu2.demo.model.indexmodel.HomepageRaiders;
import com.yitu2.demo.model.indexmodel.homepageADmodel;
import com.yitu2.demo.model.indexmodel.homepageActivityModel;
import com.yitu2.demo.model.testmodel.addtestmodel;
import com.yitu2.demo.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
@Service("TestService")
public class MainServiceImpl implements MainService {
    @Resource
    private MainDao mainDao;

    /**
     * 获取首页广告
     * @return
     */
    @Override
    public List<homepageADmodel> listHomepageAD() {
        List<homepageADmodel> list = mainDao.listHomepageAD();
        return list;
    }

    /**
     * 获取首页同城活动
     * @return
     */
    @Override
    public List<homepageActivityModel> listHomepageActivity() {
        List<homepageActivityModel> list = mainDao.listHomepageActivity();
        return list;
    }

    /**
     * 获取首页查攻略
     * @return
     */
    @Override
    public List<HomepageRaiders> listHomepageRaiders() {
        List<HomepageRaiders> list = mainDao.listHomepageRaiders();
        return list;
    }

    /**
     * 添加尝试
     * @param par
     * @param session
     */
    @Override
    public int addtest(String par, HttpSession session) {
        addtestmodel a = new addtestmodel("132456");
        mainDao.addtest(a);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        session.setAttribute("Progress","100");
        int i = a.getPid();
        return i;
    }

    /**
     * 多线程减去商品测试
     * @return
     */
    @Override
    public int selvaltest() {
//        javathreadmodel a = new javathreadmodel();
//        mainDao.minustest(a);
//        int i = a.getNum();
        mainDao.minustest();
        return mainDao.selvaltest();
    }

    /**
     * 商品恢复数量 200
     * @return
     */
    @Override
    public void addth() {
        mainDao.addth();
    }


}

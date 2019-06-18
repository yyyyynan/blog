package com.yitu2.demo.dao;

import com.yitu2.demo.model.indexmodel.HomepageRaiders;
import com.yitu2.demo.model.indexmodel.homepageADmodel;
import com.yitu2.demo.model.indexmodel.homepageActivityModel;
import com.yitu2.demo.model.testmodel.addtestmodel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 */
public interface MainDao {

    /**
     * 获取首页广告 前九条
     * @return
     */
    @Select("SELECT id,photo,link FROM `homepage_ad` order by `homepage_ad`.order limit 0,9")
    List<homepageADmodel> listHomepageAD();

    /**
     * 获取首页同城活动 最前面一条
     * @return
     */
    @Select("SELECT id,title,img,link FROM `homepage_activity` LIMIT 0,1")
    List<homepageActivityModel> listHomepageActivity();

    /**
     * 获取首页查攻略
     * @return
     */
    @Select("select id,addr,title,link from `homepage_raiders` LIMIT 0,8")
    List<HomepageRaiders> listHomepageRaiders();

    /**
     * 添加尝试
     * @param par
     * @return
     */
    @SelectKey(statement="select max(pid)+1 as myNo from test" , before=true,keyColumn="myNo",resultType=int.class,keyProperty="pid")
    @Insert("INSERT INTO `test` (`personid`) VALUES (#{personid})")
    void addtest(addtestmodel par);

    /**
     * 减去一个值尝试
     */
    @SelectKey(statement="select min(pid)+1 as myNo from test" , before=true,keyColumn="myNo",resultType=int.class,keyProperty="pid")
    @Delete("DELETE FROM `test` limit 1;")
    void deltest();

    /**
     * 多线程减去商品测试
     * @return
     */
    @Select("select num from threadtest where id = 1")
    int selvaltest();

//    /**
//     * 测试
//     * @param a
//     */
//    @SelectKey(statement="select num as myNo from threadtest where id = 1" , before=false,keyColumn="myNo",resultType=int.class,keyProperty="num")
//    @Update("UPDATE `threadtest` SET `num`=  num - 1 WHERE (`id`='1')")
//    void minustest(javathreadmodel a);
    /**
     * 测试
     */
    @Update("UPDATE `threadtest` SET `num`=  num - 1 WHERE (`id`='1')")
    void minustest();

    /**
     * 商品恢复数量 200
     * @return
     */
    @Update("UPDATE `threadtest` SET `num`=  200 WHERE (`id`='1')")
    void addth();
}

package com.yitu2.demo.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yitu2.demo.constant.BasicConstant;
import com.yitu2.demo.model.indexmodel.HomepageRaiders;
import com.yitu2.demo.model.indexmodel.homepageADmodel;
import com.yitu2.demo.model.indexmodel.homepageActivityModel;
import com.yitu2.demo.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@RestController
@Slf4j
//@Scope("request")
public class MainController {
    @Resource
    private MainService mainService;

    private final static Logger log = LoggerFactory.getLogger(MainController.class);
    //缓存
//    @Cacheable(cacheNames = "HomepageAD",key = "1")

    /**
     * 获取首页广告列表
     *
     * @return
     */
    @RequestMapping("/listHomepageAD")
    public Map<String, Object> listHomepageAD() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<homepageADmodel> data = mainService.listHomepageAD();
        log.info("listHomepageAD");
        resultMap.put("status", "200");
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * 获取首页同城活动
     *
     * @return
     */
    @RequestMapping("/listHomepageActivity")
    public Map<String, Object> listHomepageActivity() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<homepageActivityModel> data = mainService.listHomepageActivity();
        log.info("listHomepageActivity");
        resultMap.put("status", "200");
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * 获取首页查攻略
     *
     * @return
     */
    @RequestMapping("/listHomepageRaiders")
    public Map<String, Object> listHomepageRaiders() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<HomepageRaiders> data = mainService.listHomepageRaiders();
        log.info("listHomepageRaiders");
        resultMap.put("status", "200");
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * 登录检测函数
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/logincheck")
    public Map<String, Object> logincheck(@RequestParam("username") String username, @RequestParam("password") String password) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //3.执行登录方法
        try {
            log.info("user " + username + "login success");
            subject.login(token);
            resultMap.put("status", "200");
            //登录成功
            //跳转到test.html
            return resultMap;
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            resultMap.put("status", "103");
            return resultMap;
        } catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            resultMap.put("status", "104");
            return resultMap;
        }

    }

    /**
     * 添加尝试
     */
    @RequestMapping("/addtest")
    public int addtest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("Progress", "10");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        session.setAttribute("Progress", "50");
        int i = mainService.addtest("13245679879", session);
        return i;
    }


    /**
     * 获取进度并返回
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getProgress")
    public String getProgress(HttpServletRequest request, HttpServletResponse response) {
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        String i = (String) session.getAttribute("Progress");
        System.out.println(i);
        return i;
    }

    int sumnum = 0;
    Object object = new Object();
    long startTime = System.currentTimeMillis();
    int[] num = {0};
    threadtest t = new threadtest();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            BasicConstant.corePoolSize,
            BasicConstant.maximumPoolSizeSize,
            BasicConstant.keepAliveTime,
            TimeUnit.SECONDS,
            BasicConstant.workQueue,
            new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());

    /**
     * 多线程减去商品测试
     *
     * @return
     */
    @RequestMapping("/selvaltest")
    public int selvaltest(HttpServletRequest request) {
//        executor.execute(() -> new Thread(t).start());
        executor.execute(t);
//        executor.submit(t);
//        Thread tt = new Thread(t);
//        tt.start();
        sumnum++;
//        System.out.println(sumnum);
        return sumnum;
    }


    /**
     * 商品恢复数量 200
     *
     * @return
     */
    @RequestMapping("/addth")
    public void addth() {
        mainService.addth();
    }

    public class threadtest implements Runnable{
        @Override
        public void run() {
            synchronized (object){
                int num2 = 0;
                try {
//                    Thread.currentThread().join();
                    num2 = mainService.selvaltest();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (num2 == 199){
                    startTime = System.currentTimeMillis();
                }
                num[0] = num2;
//                System.out.println(Thread.currentThread().getName() + "购买了一个 还剩下" + num[0] + "个");
                if (num[0] <= 0) {
                    System.out.println(System.currentTimeMillis()-startTime+"ms");
                    mainService.addth();
                }
            }
        }
    }
}


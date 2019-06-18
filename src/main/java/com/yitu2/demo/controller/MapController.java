package com.yitu2.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
@Slf4j
public class MapController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index2(){
        return "index";
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 后台
     * @return
     */
    @RequestMapping("/Backstage")
    public String Backstage(){
        return "Backstage";
    }

    /**
     * 无权限界面
     * @return
     */
    @RequestMapping("/noperm")
    public String noperm(){
        return "noperm";
    }

    /**
     * 多线程测试界面
     * @return
     */
    @RequestMapping("/Threadtest")
    public String Threadtest(){
        return "Threadtest";
    }

    @RequestMapping("/echartstest")
    public String echartstest(){
        return "echartstest";
    }

    @RequestMapping("/notes")
    public String bmap(){
        return "/second/notes";
    }

    @RequestMapping("/main")
    public String ma(){
        return "/second/main";
    }

}

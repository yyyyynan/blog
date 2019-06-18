package com.yitu2.demo.shiro;

import com.yitu2.demo.service.RealmService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * shiro 框架认证或者授权部分的代码
 * @author Administrator
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Resource
    RealmService realmService;

    private final static Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);

    private String ADMIN = "admin";

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        log.info("执行授权逻辑");
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        //添加资源的授权字符串
        info.addStringPermission(realmService.getPermByName(username));
        info.addStringPermission(realmService.getPermByName("admin"));
        return info;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        log.info("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) arg0;
        if (!realmService.checkUsername(token.getUsername())) {
            //用户名不存在 shiro底层会抛出UnKnowAccountException
            return null;
        }
        String password = realmService.getPasswordByUsername(token.getUsername());
        //2.判断密码
        return new SimpleAuthenticationInfo(token.getUsername(), password, "");

    }

}

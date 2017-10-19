package com.example.myoltuoauth2startersimple;

import com.github.ganity.oauth2.AuthzCallback;
import com.github.ganity.oauth2.OAuth2AccessToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class DemoController {
    @RequestMapping("/index")
    public Object index(HttpSession session) {

        Subject subject = SecurityUtils.getSubject();
        Object object2 = subject.getSession().getAttribute(AuthzCallback.AUTH_ACCESS_TOKEN);
        Object x = subject.getPrincipals();
        System.err.println("has role " + subject.hasRole("role_2"));
        System.err.println("has role " + subject.hasRole("admin"));
        System.err.println("has Permission " + subject.isPermitted("abcefffdfdf_a_3"));
        OAuth2AccessToken accessToken = (OAuth2AccessToken) object2;
        System.err.println(accessToken.getAccessToken());
        return subject.getPrincipal();
    }
    @RequestMapping("/anon")
    public String anon() {

        return "anon";
    }
    @RequestMapping("/perm")
    @RequiresPermissions("abcefffdfdf_a_3")
    public String permission() {

        return "anon";
    }
    @RequestMapping("/perm6")
    @RequiresPermissions("abcefffdfdf_a_6")
    public String permission6() {

        return "anon";
    }
}

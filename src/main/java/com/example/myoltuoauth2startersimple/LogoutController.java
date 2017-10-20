package com.example.myoltuoauth2startersimple;

import com.github.ganity.oauth2.AuthzCallback;
import com.github.ganity.oauth2.OAuth2AccessToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping(value = "/toLogout", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        return new ModelAndView("logout");
    }

    @RequestMapping(value = "/asLogout", method = RequestMethod.GET)
    public ModelAndView asLogout(HttpSession session) {
        return new ModelAndView("logout_sucess");
    }

}

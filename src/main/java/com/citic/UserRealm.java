package com.citic;

import com.github.ganity.oauth2.shiro.OAuth2AuthorizingRealm;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends OAuth2AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userId = (String) super.getAvailablePrincipal(principals);
        // 获得用户角色
        List<String> userRoles = new ArrayList<String>();
        userRoles.add("USER");
        userRoles.add("role_2");

        // 获取权限
        info.addStringPermission("abcefffdfdf_a_1");
        info.addStringPermission("abcefffdfdf_a_2");
        info.addStringPermission("abcefffdfdf_a_3");
        info.addStringPermission("abcefffdfdf_a_4");
        info.addRoles(userRoles);
        return info;
    }
}

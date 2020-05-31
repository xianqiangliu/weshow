package com.jianzhonglang.weshow.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.jianzhonglang.weshow.entity.User;
import com.jianzhonglang.weshow.service.UserService;
import com.jianzhonglang.weshow.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xianqiangliu
 * @since 2020/5/30
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired private JwtUtils jwtUtils;

    @Autowired private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken)authenticationToken;
        String userId = jwtUtils.getClaimByToken((String)jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(userId);
        if (null == user){
            throw new UnknownAccountException("账户不存在");
        }

        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已经被锁定");
        }

        AccountProfile accountProfile = new AccountProfile();
        BeanUtil.copyProperties(user, accountProfile);

        return new SimpleAuthenticationInfo(accountProfile, jwtToken.getCredentials(), getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
}

package com.jianzhonglang.weshow.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author xianqiangliu
 * @since 2020/5/30
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

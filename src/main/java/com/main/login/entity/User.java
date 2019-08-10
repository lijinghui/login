package com.main.login.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Lneoi.li
 * @ClassName User
 * @Description
 * @date 2019/8/8 13:57
 **/
@Data
public class User implements  UserDetails {

    private String id;

    private String username;

    private String password;

    private String verifyCode;

    // TODO UserDetails 里面的过期等字段应该扩展到登录用户表


    public User() {
    }

    /**
     * //返回分配给用户的角色列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *  账户是否激活
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

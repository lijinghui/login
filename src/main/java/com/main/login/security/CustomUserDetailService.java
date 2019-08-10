package com.main.login.security;

import com.main.login.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Lneoi.li
 * @ClassName UserDetailService
 * @Description
 * @date 2019/8/8 13:39
 **/
@Service
public class CustomUserDetailService implements UserDetailsService,Serializable {

    /**
     * 重写通过用户名获取账号
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);
        //在这里可以自己调用数据库，对username进行查询，看看在数据库中是否存在
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        return user;
    }
}

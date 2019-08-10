package com.main.login.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.login.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Lneoi.li
 * @ClassName JWTLoginFilter
 * @Description
 * @date 2019/8/9 15:24
 *
 * * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 *  * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 *  * attemptAuthentication ：接收并解析用户凭证。
 *  * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 *
 * ---------------------
 * 版权声明：本文为CSDN博主「迷彩风情」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/sxdtzhaoxinguo/article/details/77965226
 **/
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setAuthenticationManager(this.authenticationManager);
    }

    /**
     *  接收并解析用户凭证
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {


            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getParameter("username"),
                            req.getParameter("password"),
                            new ArrayList<>())
            );
    } */

    /**
     * 成功写 token
     * @param req
     * @param res
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        res.addHeader("Authorization", token);
    }
}

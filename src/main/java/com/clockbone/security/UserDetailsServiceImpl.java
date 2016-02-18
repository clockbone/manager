package com.clockbone.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by qinjun on 2016/2/16.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Admin admin = mainMapper.getAdminByUsername(username);
        System.out.println("power auth");
        //todo 通过username 获取权限
        if(!username.equals("admin")){
            //校验不通过，会转到  authentication-failure-url="/user/login?login=false"
            throw new UsernameNotFoundException("Admin not found.");
        }
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        //用户校验通过后添加权限，先添加基本权限：ROLE_USER
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        auths.add(authority);
        //todo get roles;get pwd
        String roles = "";
        String pwd = "";
        String[] roleArray = roles.split(",");
        /*for(String role : roleArray) {
            auths.add(new SimpleGrantedAuthority(role));
        }*/
        User user = new User(username, pwd, auths);
        return user;

    }
}

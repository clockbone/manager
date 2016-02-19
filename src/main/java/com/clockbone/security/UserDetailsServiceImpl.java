package com.clockbone.security;

import com.clockbone.mapper.UserMapper;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(Strings.isNullOrEmpty(username)){
            //校验不通过，会转到  authentication-failure-url="/user/login?login=false"
            throw new UsernameNotFoundException("username is null or empty.");
        }
        com.clockbone.domain.User mangerUser = userMapper.getUserByName(username);
        if(null == mangerUser){
            throw new UsernameNotFoundException(username+" not found.");
        }
        System.out.println("power auth");


        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        //用户校验通过后添加权限，先添加基本权限：ROLE_USER
        //  用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        auths.add(authority);
       /* String roles = mangerUser.getRoles();
        String[] roleArray = roles.split(",");
        for(String role : roleArray) {
            auths.add(new SimpleGrantedAuthority(role));
        }*/
        mangerUser.setPassWord("admin");
        User user = new User(username, "", auths);
        return user;

    }
}

package com.clockbone.mapper;

import com.clockbone.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by qinjun on 2016/2/18.
 */
public interface UserMapper {

    @Select(" select userId userId,userName userName,userPassword passWord from user where userName=#{userName}")
    public User getUserByName(String name);

    @Select(" select roleKey from role r where id in (select role_id from user_role ur where ur.user_id=#{userId})")
    public List<String> getRolesById(String userId);

    @Select("select rolekey from role where enable=1;")
    public List<String> getAllRoles();


    @Select("select tr.type  from t_resource tr,role r, t_role_resource trr  where tr.id=trr.resource_id and r.id=trr.role_id and r.roleKey=#{roleKey}")
    public List<String> getResourecRole(String role);


}

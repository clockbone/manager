package com.clockbone.mapper;

import com.clockbone.domain.User;

import java.util.List;

/**
 * Created by qinjun on 2016/2/18.
 */
public interface UserMapper {

    public User getUserByName(String name);

    public List<String> getRolesById(String userId);
}

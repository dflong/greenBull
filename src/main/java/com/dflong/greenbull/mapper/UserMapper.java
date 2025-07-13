package com.dflong.greenbull.mapper;

import com.dflong.greenbull.entity.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper {

    public User getUser(User user);

    public void updateUser(User user);

}

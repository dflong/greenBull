package com.dflong.greenbull.service;

import com.dflong.greenbull.entity.User;
import com.dflong.greenbull.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    public String getUser(long id) {
        User param = new User();
        param.setId(1);
        param.setUnionid("12345");
        param.setTableName("user");
        User user = userMapper.getUser(param);

        return user.getNickname();
    }
}

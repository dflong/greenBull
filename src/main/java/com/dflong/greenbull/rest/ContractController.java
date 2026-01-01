package com.dflong.greenbull.rest;

import com.alibaba.fastjson.JSON;
import com.dflong.greenbull.entity.ContractInfo;
import com.dflong.greenbull.service.ContractService;
import com.dflong.greenbull.service.RedisService;
import com.dflong.greenbull.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController implements ApplicationContextAware {

    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

    ApplicationContext applicationContext;

    // http://127.0.0.1:8081/contractInfo?unionId=55555
    @RequestMapping("/contractInfo")
    @ResponseBody
    public ContractInfo contractInfo(@RequestParam String unionId) {
        return redisService.getContractInfo(unionId);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

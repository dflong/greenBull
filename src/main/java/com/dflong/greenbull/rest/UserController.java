package com.dflong.greenbull.rest;

import com.dflong.greenbull.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements ApplicationContextAware {

    @Autowired
    UserService userService;

    ApplicationContext applicationContext;

    // http://127.0.0.1:8080/hello?id=1
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam long id) {
        return "Hello " + userService.getUser(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

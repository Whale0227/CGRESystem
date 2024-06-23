package org.ncre.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncre.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class serviceTest {
    @Autowired
    private NCREService cgermService;

    @Test
    public void GetAllAdministrator(){
        System.out.println(cgermService.GetAllAdministratorAccount());
    }
    @Test
    public void GetUserInfoByAccount(){
        System.out.println(cgermService.GetUserInfoByAccount("1"));
    }
}

package org.ncre.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncre.config.SpringConfig;
import org.ncre.data.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class serviceTest {
    @Autowired
    private NCREService cgermService;

    @Test
    public void GetUserInfoByAccount(){
        System.out.println(cgermService.GetUserInfoByAccount("1"));
    }
    @Test
    public void SaveUserAcPw(){
        UserAccount userAccount = new UserAccount();
        userAccount.setAccount("");
        userAccount.setPassword("1");
        cgermService.SaveUserAcPw(userAccount);
    }
}

package org.ncre.service.impl;


import org.ncre.data.dao.AdministratorAccountDao;
import org.ncre.data.dao.UserDao;
import org.ncre.data.domain.AdministratorAccount;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.ncre.service.NCREService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
@Service
public class NCREServiceImpl implements NCREService {
    @Autowired
    private AdministratorAccountDao administerAccountdao;
    @Autowired
    private UserDao userDao;

    private User user;
    @Override
    public List<AdministratorAccount> GetAllAdministratorAccount() {
        return administerAccountdao.getAllAccounts();
    }

    @Override
    public UserAccount GetUserAPByAccount(String account) {
        return userDao.FindAPByAccount(account);
    }

    @Override
    public UserInfo GetUserInfoByAccount(String account) {
        return userDao.FindInformationByAccount(account);
    }

    @Override
    public AdministratorAccount GetADAccountByAccount(String account) {
        return administerAccountdao.getByAccount(account);
    }

    @Override
    public boolean SaveUserAcPw(UserAccount userAccount) {
        boolean Check = false;
        if(GetUserAPByAccount(userAccount.getAccount()) == null){
            userDao.SaveAcPw(userAccount);
            Check = true;
        }else{
            JOptionPane.showMessageDialog(null, "该账户已存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
       return Check;
    }

    @Override
    public boolean SaveUserInfo(UserInfo userInfo) {
        String regex = "1\\d{10}";//定义手机号规则
        boolean flag = userInfo.getPhone().matches(regex);//判断功能
        if (flag) {
            userDao.SaveAllInfoByAccount(userInfo);
        }else {
            JOptionPane.showMessageDialog(null, "请填写正确的手机号！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }
}

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
    public void SaveUserAcPw(UserAccount userAccount) {
        userDao.SaveAcPw(userAccount);
    }

    @Override
    public void SaveUserInfo(UserInfo userInfo) {
         userDao.SaveAllInfoByAccount(userInfo);
    }
}

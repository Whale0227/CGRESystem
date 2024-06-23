package org.ncre.service;

import org.ncre.data.domain.AdministratorAccount;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;

import java.util.List;

public interface NCREService {
    List<AdministratorAccount> GetAllAdministratorAccount();
    User GetUserInfoByAccount(String account);
    UserAccount GetUserAPByAccount(String account);
    AdministratorAccount GetADAccountByAccount(String account);
    void SaveUserAcPw(UserAccount userAccount);
    void SaveUserInfo(UserInfo userInfo);
}

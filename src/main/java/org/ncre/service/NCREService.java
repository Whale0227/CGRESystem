package org.ncre.service;

import org.ncre.data.domain.AdministratorAccount;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;

import java.util.List;

public interface NCREService {
    List<AdministratorAccount> GetAllAdministratorAccount();
    UserInfo GetUserInfoByAccount(String account);
    UserAccount GetUserAPByAccount(String account);
    AdministratorAccount GetADAccountByAccount(String account);
    boolean SaveUserAcPw(UserAccount userAccount);
    boolean SaveUserInfo(UserInfo userInfo);
    void DeleteUserInfoAccountByAccount(UserAccount userAccount);
}

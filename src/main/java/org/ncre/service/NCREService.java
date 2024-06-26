package org.ncre.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.ncre.data.domain.AdministratorAccount;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
@Transactional // 事务传播行为
public interface NCREService {
    List<AdministratorAccount> GetAllAdministratorAccount();
    UserInfo GetUserInfoByAccount(String account);
    UserAccount GetUserAPByAccount(String account);
    AdministratorAccount GetADAccountByAccount(String account);
    boolean SaveUserAcPw(UserAccount userAccount);
    boolean SaveUserInfo(UserInfo userInfo);
    void DeleteUserInfoAccountByAccount(UserAccount userAccount);

    List<User> AddUserInfos(List<User> users);
    boolean UpdateUserInfo(User user);
    List<User> GetAllUsersInfoByAccount(String account);
    List<User> GetAllUsersInfoByName(String name);
    List<User> GetAllUsersInfoByPhone(String phone);
    List<User> GetAllUsersInfoBySchoolid(String schoolid);
    List<User> GetAllUsersInfoBySchool(String school);

}

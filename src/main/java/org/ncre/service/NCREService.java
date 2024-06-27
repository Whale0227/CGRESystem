package org.ncre.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.ncre.data.domain.AdministratorAccount;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
public interface NCREService {
    // 根据账号查找用户信息
    UserInfo GetUserInfoByAccount(String account);
    // 根据账号查找用户的账号密码
    UserAccount GetUserAPByAccount(String account);
    // 根据账号查找管理员的账号密码
    AdministratorAccount GetADAccountByAccount(String account);
    // 保存用户的账号密码到数据库
    boolean SaveUserAcPw(UserAccount userAccount);
    // 保存用户的信息到数据库
    boolean SaveUserInfo(UserInfo userInfo);
    // 根据用户的账号删除用户信息
    void DeleteUserInfoAccountByAccount(UserAccount userAccount);
    // 批量添加账户，如果遇到错误，返回错误的账户
    List<User> AddUserInfos(List<User> users);
    // 修改用户的信息
    boolean UpdateUserInfo(User user);
    // 根据用户账户模糊查找所有相关信息
    List<User> GetAllUsersInfoByAccount(String account);
    // 根据用户姓名模糊查找所有相关信息
    List<User> GetAllUsersInfoByName(String name);
    // 根据用户手机号模糊查找所有相关信息
    List<User> GetAllUsersInfoByPhone(String phone);
    // 根据用户学号模糊查找所有相关信息
    List<User> GetAllUsersInfoBySchoolid(String schoolid);
    // 根据用户学校模糊查找所有相关信息
    List<User> GetAllUsersInfoBySchool(String school);
}

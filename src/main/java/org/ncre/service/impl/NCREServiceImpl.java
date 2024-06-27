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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NCREServiceImpl implements NCREService {
    @Autowired
    private AdministratorAccountDao administerAccountdao;
    @Autowired
    private UserDao userDao;
    @Override
    public UserAccount GetUserAPByAccount(String account) {
        return userDao.GetAPByAccount(account);
    }
    @Override
    public UserInfo GetUserInfoByAccount(String account) {
        return userDao.GetInfoByAccount(account);
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
            userDao.SaveInfoInit(userAccount);
            Check = true;
        }else{
            JOptionPane.showMessageDialog(null, "该账户已存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
       return Check;
    }
    @Override
    public boolean SaveUserInfo(UserInfo userInfo) {
        boolean FlagPhone = false;
        if((userInfo.getExamerank()!=null&& !Objects.equals(userInfo.getExamerank(), "无"))&&
                (Objects.equals(userInfo.getName(), "") || Objects.equals(userInfo.getGender(), "-请选择-") ||
                        Objects.equals(userInfo.getPhone(), "") || Objects.equals(userInfo.getSchoolid(), "") ||
                        Objects.equals(userInfo.getSchool(), ""))){
            JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
        }else {
            String regex = "1\\d{10}";//定义手机号规则
            FlagPhone = userInfo.getPhone().matches(regex);//判断功能
            if (FlagPhone) {
                userDao.UpadteAllInfoByAccount(userInfo);
            } else {
                JOptionPane.showMessageDialog(null, "请填写正确的手机号！", "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        }
        return FlagPhone;
    }
    public void DeleteUserInfoAccountByAccount(UserAccount userAccount){
        userDao.DeleteUserInfoByAccount(userAccount);
        userDao.DeleteUserAccountByAccount(userAccount);
    }
    @Override
    public boolean UpdateUserInfo(User user) {
        UserInfo userInfo = user.getUserInfo();
        UserAccount userAccount = user.getAccount();
        if(Objects.equals(userAccount.getPassword(), "")|| (Objects.equals(userInfo.getName(), "") ||
                Objects.equals(userInfo.getGender(), "") || Objects.equals(userInfo.getPhone(), "") ||
                Objects.equals(userInfo.getSchoolid(), "") || Objects.equals(userInfo.getSchool(), ""))){
            JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            userDao.UpadtePasswordByAccount(userAccount);
            userDao.UpadteAllInfoByAccount(userInfo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    private List<User> getUsers(List<User> users, List<UserInfo> infos, List<UserAccount> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            User t = new User();
            t.setAccount(accounts.get(i));
            t.setUserInfo(infos.get(i));
            users.add(t);
        }
        return users;
    }
    @Override
    public List<User> GetAllUsersInfoByAccount(String account) {
        account = "%"+account+"%";
        List<User> Users = new ArrayList<>();
        List<UserInfo> infos = userDao.GetAllUsersInfoByAccount(account);
        List<UserAccount> accounts = userDao.GetAllUsersAccountByAccount(account);
        return getUsers(Users, infos, accounts);
    }
    @Override
    public List<User> GetAllUsersInfoByName(String name) {
        name = "%"+name+"%";
        List<User> Users = new ArrayList<>();
        List<UserInfo> infos = userDao.GetAllUsersInfoByName(name);
        List<UserAccount> accounts  = new ArrayList<>();
        for (UserInfo info : infos) {
            UserAccount TUserAccount = userDao.GetAPByAccount(info.getAccount());
            accounts.add(TUserAccount);
        }
        return getUsers(Users, infos, accounts);
    }
    @Override
    public List<User> GetAllUsersInfoByPhone(String phone) {
        phone = "%"+phone+"%";
        List<User> Users = new ArrayList<>();
        List<UserInfo> infos = userDao.GetAllUsersInfoByPhone(phone);
        List<UserAccount> accounts  = new ArrayList<>();
        for (UserInfo info : infos) {
            UserAccount TUserAccount = userDao.GetAPByAccount(info.getAccount());
            accounts.add(TUserAccount);
        }

        return getUsers(Users, infos, accounts);
    }
    @Override
    public List<User> GetAllUsersInfoBySchoolid(String schoolid) {
        schoolid = "%"+schoolid+"%";
        List<User> Users = new ArrayList<>();
        List<UserInfo> infos = userDao.GetAllUsersInfoBySchoolid(schoolid);
        List<UserAccount> accounts  = new ArrayList<>();
        for (UserInfo info : infos) {
            UserAccount TUserAccount = userDao.GetAPByAccount(info.getAccount());
            accounts.add(TUserAccount);
        }

        return getUsers(Users, infos, accounts);
    }
    @Override
    public List<User> GetAllUsersInfoBySchool(String school) {
        school = "%"+school+"%";
        List<User> Users = new ArrayList<>();
        List<UserInfo> infos = userDao.GetAllUsersInfoBySchool(school);
        List<UserAccount> accounts  = new ArrayList<>();
        for (UserInfo info : infos) {
            UserAccount TUserAccount = userDao.GetAPByAccount(info.getAccount());
            accounts.add(TUserAccount);
        }
        return getUsers(Users, infos, accounts);
    }
    @Override
    public List<User> AddUserInfos(List<User> users) {
        if(users.isEmpty()){
            return null;
        }
        int len = users.size();
        for (int i = 0;i<len;i++) {
            if (userDao.GetAPByAccount(users.get(i).getAccount().getAccount()) != null) {
                JOptionPane.showMessageDialog(null, "账户" + users.get(i).getAccount().getAccount() + "已存在，请检查！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return users;
            }
            try {
                userDao.SaveAcPw(users.get(i).getAccount());
                userDao.SaveInfoInit(users.get(i).getAccount());
                userDao.UpadteAllInfoByAccount(users.get(i).getUserInfo());
                users.remove(i);
                len--;
                i--;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "请填写正确信息，请检查！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return users;
            }
        }
        return users;
    }
}

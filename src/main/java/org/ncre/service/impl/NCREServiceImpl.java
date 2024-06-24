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
import java.util.Objects;

@Service
public class NCREServiceImpl implements NCREService {
    @Autowired
    private AdministratorAccountDao administerAccountdao;
    @Autowired
    private UserDao userDao;
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
            userDao.SaveInfoInit(userAccount);
            Check = true;
        }else{
            JOptionPane.showMessageDialog(null, "该账户已存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
       return Check;
    }
    @Override
    public boolean SaveUserInfo(UserInfo userInfo) {

//            if ((!Objects.equals(ReviseInfoRankJTF.getText(), "") || !Objects.equals(ReviseInfoRankJTF.getText(), "无")) &&
//                    (Objects.equals(SignUpNameJTF.getText(), "") || Objects.equals(SignUpAgeJTF.getText(), "") ||
//                    Objects.equals(SignUpSchoolidJTF.getText(), "") || Objects.equals(SignUpPhoneJTF.getText(), "") ||
//                    Objects.equals(SignUpSchoolJTF.getText(), "") || SignUpGender.getSelectedItem() == "-请选择-")
//                    ) {
//                JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
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
}

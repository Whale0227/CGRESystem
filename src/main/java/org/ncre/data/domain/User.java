package org.ncre.data.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private UserAccount account;
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "User{" +
                "account=" + account +
                ", userInfo=" + userInfo +
                '}';
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}

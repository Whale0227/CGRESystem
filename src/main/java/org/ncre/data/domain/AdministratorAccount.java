package org.ncre.data.domain;

import org.springframework.stereotype.Component;

@Component
public class AdministratorAccount {
    private Integer id;
    private String account;
    private String password;
    @Override
    public String toString() {
        return "Account: "+account+"\n"+
                "Password: "+password+"\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

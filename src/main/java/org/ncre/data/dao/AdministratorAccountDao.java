package org.ncre.data.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ncre.data.domain.AdministratorAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorAccountDao {
    @Insert("insert into administratoraccount (account, password) values (#{account},#{password})")
    void save(AdministratorAccount account);
    @Select("select * from administratoraccount where account = #{account}")
    AdministratorAccount getByAccount(String account);
    @Select("select * from administratoraccount")
    List<AdministratorAccount> getAllAccounts();
}

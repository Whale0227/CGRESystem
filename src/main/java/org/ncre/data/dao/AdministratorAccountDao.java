package org.ncre.data.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ncre.data.domain.AdministratorAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorAccountDao {
    @Select("select * from administratoraccount where account = #{account}")
    AdministratorAccount getByAccount(String account);
}

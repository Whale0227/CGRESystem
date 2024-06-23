package org.ncre.data.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.springframework.stereotype.Component;
@Component
public interface UserDao {
    @Insert("insert into userinfo (account,name, schoolid, gender, age, phone, school,examerank) values (#{account},#{name},#{schoolid},#{gender},#{age},#{phone},#{school},#{examerank})")
    void SaveAllInfoByAccount(UserInfo userInfo);
    @Select("select *from useraccount where account = #{account}")
    UserAccount FindAPByAccount(String account);
    @Select("select *from userinfo where account = #{account}")
    UserInfo FindInformationByAccount(String account);
    @Insert("insert into useraccount(account,password) values (#{account},#{password})")
    void SaveAcPw(UserAccount account);

}
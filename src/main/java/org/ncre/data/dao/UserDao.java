package org.ncre.data.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.springframework.stereotype.Component;
@Component
public interface UserDao {

    @Update("update userinfo set userinfo.name = #{name},userinfo.schoolid = #{schoolid},userinfo.gender = #{gender}," +
            "age = #{age},phone = #{phone},school = #{school},examerank = #{examerank} where account = #{account}")
    void UpadteAllInfoByAccount(UserInfo userInfo);
    @Insert("insert into userinfo(account)values (#{account})")
    void SaveInfoInit(UserAccount userAccount);
    @Select("select *from useraccount where account = #{account}")
    UserAccount FindAPByAccount(String account);
    @Select("select *from userinfo where account = #{account}")
    UserInfo FindInformationByAccount(String account);
    @Insert("insert into useraccount(account,password) values (#{account},#{password})")
    void SaveAcPw(UserAccount account);
    @Delete("delete from useraccount where account = #{account}")
    void DeleteUserAccountByAccount(UserAccount userAccount);
    @Delete("delete from userinfo where account = #{account}")
    void DeleteUserInfoByAccount(UserAccount userAccount);
}
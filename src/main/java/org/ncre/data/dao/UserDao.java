package org.ncre.data.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    @Update("update userinfo set userinfo.name = #{name},userinfo.schoolid = #{schoolid},userinfo.gender = #{gender}," +
            "userinfo.age = #{age},userinfo.phone = #{phone},userinfo.school = #{school}," +
            "userinfo.examerank = #{examerank} where userinfo.account = #{account}")
    void UpadteAllInfoByAccount(UserInfo userInfo);
    @Update("update useraccount set password = #{password} where account = #{account}")
    void UpadtePasswordByAccount(UserAccount userAccount);
    @Insert("insert into userinfo(account)values (#{account})")
    void SaveInfoInit(UserAccount userAccount);
    @Select("select *from useraccount where account = #{account}")
    UserAccount GetAPByAccount(String account);
    @Select("select *from userinfo where account = #{account}")
    UserInfo GetInfoByAccount(String account);
    @Insert("insert into useraccount(account,password) values (#{account},#{password})")
    void SaveAcPw(UserAccount account);
    @Delete("delete from useraccount where account = #{account}")
    void DeleteUserAccountByAccount(UserAccount userAccount);
    @Delete("delete from userinfo where account = #{account}")
    void DeleteUserInfoByAccount(UserAccount userAccount);

    @Select("select *from useraccount where account like #{account}")
    List<UserAccount> GetAllUsersAccountByAccount(String account);
    @Select("select *from userinfo where account like #{account}")
    List<UserInfo> GetAllUsersInfoByAccount(String account);
    @Select("select *from userinfo where name like #{name}")
    List<UserInfo> GetAllUsersInfoByName(String name);
    @Select("select *from userinfo where phone like #{phone}")
    List<UserInfo> GetAllUsersInfoByPhone(String phone);
    @Select("select *from userinfo where schoolid like #{schoolid}")
    List<UserInfo> GetAllUsersInfoBySchoolid(String schoolid);
    @Select("select *from userinfo where school like #{school}")
    List<UserInfo> GetAllUsersInfoBySchool(String school);

}
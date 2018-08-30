package com.bupt317.study.lab_manager.mapper;

import com.bupt317.study.lab_manager.pojo.mybatis.UserInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInformationMapper
{
    //插入用户名，和user表同步
    int insertuserinformation(UserInformation userInformation);

    //根据用户名删除
    int deletebyusername(String username);

    //int deletebyid(int id);

    //根据用户id更新
    int updatebyid(UserInformation userInformation);

    //根据用户名查询
    UserInformation selectbyusername(String username);

    //查询所有用户信息
    List<UserInformation> selectall();
}

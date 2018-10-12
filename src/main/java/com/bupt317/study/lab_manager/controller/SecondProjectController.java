package com.bupt317.study.lab_manager.controller;

import com.bupt317.study.lab_manager.pojo.mybatis.User;
import com.bupt317.study.lab_manager.pojo.mybatis.UserInformation;
import com.bupt317.study.lab_manager.service.UserInformationService;
import com.bupt317.study.lab_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SecondProjectController
{
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    UserService userService;

    //修改用户信息界面跳转
    @RequestMapping(value = "/thirdpage/alteruser")
    public String toalteruser()
    {
        return "/thirdpage/alteruser";
    }

    //修改权限界面跳转
    @RequestMapping(value = "/authmanager")
    private String toauthmanager()
    {
        return "/authmanager";
    }

    //查询所有用户信息
    @RequestMapping(value = "/userinformation",method = RequestMethod.POST)
    @ResponseBody
    public List<UserInformation> getuserinfo()
    {
        List<UserInformation> userInformations=new ArrayList<UserInformation>();
        userInformations=userInformationService.getall();
        return userInformations;
    }

    //根据id查询用户信息
    @RequestMapping(value = "/getuserinfo_byid",method = RequestMethod.POST)
    @ResponseBody
    public UserInformation getuserinfobyid(int id)
    {
        UserInformation userInformation=userInformationService.getbyid(id);
        return userInformation;
    }

    //更新用户信息
    @RequestMapping(value = "/userinfo_alter",method = RequestMethod.POST)
    @ResponseBody
    public String updateuserinfo(String id,String name,String studentid,String idcard,String birthday)
    {
        int intid=Integer.parseInt(id);
        UserInformation userInformation=userInformationService.userinfobuilder(intid,name,studentid,idcard,birthday);
        String flag=userInformationService.updateuserinformation(userInformation);
        return flag;
    }

    //全部用户权限查询
    @RequestMapping(value = "/getuser",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getuser()
    {
        List<User> users=new ArrayList<User>();
        users=userService.getalluser();
        return users;
    }

    //用户权限升级管理员
    @RequestMapping(value = "/level_up",method = RequestMethod.POST)
    @ResponseBody
    public String uptoauth(int id)
    {
        User user=userService.userbuilder(id,"A","null","null");
        String site=userService.updateuser(user);
        return site;
    }

    //用户权限降级普通用户
    @RequestMapping(value = "level_down",method = RequestMethod.POST)
    @ResponseBody
    public String downtopeople(int id)
    {
        User user=userService.userbuilder(id,"M","null","null");
        String site=userService.updateuser(user);
        return site;
    }


}

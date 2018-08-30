package com.bupt317.study.lab_manager.controller;

import com.bupt317.study.lab_manager.pojo.mybatis.Project;
import com.bupt317.study.lab_manager.service.ProjectService;
import com.bupt317.study.lab_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstProjectController
{
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

    //访问index页面
    @RequestMapping(value = "/index")
    public String toindex()
    {
        return "/index";
    }

    //跳转home页面
    @RequestMapping(value = "/home")
    public String tohome()
    {
        return "/home";
    }

    //program页面跳转
    @RequestMapping(value = "/program")
    public String toprogram()
    {
        return "/program";
    }

    //登陆验证返回
    @RequestMapping(value = ("/ajax_login"),method = RequestMethod.POST)
    @ResponseBody
    public String tologin(String Username,String password,String authority)
    {
        String result=userService.login(Username,password);
        return result;
    }

    //program页面处理
    @RequestMapping(value = ("/project"),method = RequestMethod.POST)
    @ResponseBody
    public List<Project> getprogram()
    {
        List<Project> projects=new ArrayList<Project>();
        projects=projectService.getall();
        return projects;
    }


}

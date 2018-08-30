package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.ProjectMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectMapper projectMapper;

    //添加工程
    public String addproject(Project project)
    {
        int x=projectMapper.insertproject(project);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    //删除工程根据id
    public String deleteproject(int id)
    {
        int x=projectMapper.deletebyid(id);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    //更新工程根据id
    public String updateproject(Project project)
    {
        int x=projectMapper.updatebyid(project);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    //根据工程名查询
    public Project getbyprojectname(String projectname)
    {
        Project project=projectMapper.selectbyprojectname(projectname);
        return project;
    }

    //根据工程状态查询
    public List<Project> getbyprojectstate(String projectstate)
    {
        List<Project> projects=projectMapper.selectbyprojectstate(projectstate);
        return projects;
    }

    //查询所有工程
    public List<Project> getall()
    {
        List<Project> projects=projectMapper.selectall();
        return projects;
    }
}

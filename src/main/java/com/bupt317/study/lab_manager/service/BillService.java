package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.BillMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService
{
    @Autowired
    private BillMapper billMapper;

    public String addbill(Bill bill)
    {
        int x=billMapper.insertbill(bill);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String deletebill(int id)
    {
        int x=billMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updatebill(Bill bill)
    {
        int x=billMapper.updatebyid(bill);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public List<Bill> getbyname(String name)
    {
        List<Bill> bills=billMapper.selectbyname(name);
        return bills;
    }

    public List<Bill> getbystudentid(String studentid)
    {
        List<Bill> bills=billMapper.selectbystudentid(studentid);
        return bills;
    }

    public List<Bill> getall()
    {
        List<Bill> bills=billMapper.selectall();
        return bills;
    }
}

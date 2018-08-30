package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.PaymentMapper;
import com.bupt317.study.lab_manager.pojo.mybatis.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService
{
    @Autowired
    private PaymentMapper paymentMapper;

    public String addpayment(Payment payment)
    {
        int x=paymentMapper.insertpayment(payment);
        if(x==1)
            return "Y";
        else
            return "N";
    }

    public String deletepayment(int id)
    {
        int x=paymentMapper.deletebyid(id);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public String updatepayment(Payment payment)
    {
        int x=paymentMapper.updatebyid(payment);
        if (x==1)
            return "Y";
        else
            return "N";
    }

    public List<Payment> getbypaymentdate(String projectdate)
    {
        List<Payment> payments=paymentMapper.selectbydate(projectdate);
        return payments;
    }

    public List<Payment> getall()
    {
        List<Payment> payments=paymentMapper.selectall();
        return payments;
    }


}

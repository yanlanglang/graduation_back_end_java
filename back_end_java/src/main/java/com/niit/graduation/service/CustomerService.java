package com.niit.graduation.service;

import com.niit.graduation.entity.Customer;

/**
 * @Author Yan Lang
 * @Date 2020/11/13
 * explain: Common 的业务接口层
 */
public interface CustomerService {


    /**
     * 判断是否添加
     * @param customer
     * @return
     */
    boolean insertCustomer(Customer customer);


    /**
     * 修改用户信息
     * @param customer
     * @return
     */
    Customer editCustomer(Customer customer);

    /**
     * 用户登录
     * @param customer
     * @return
     */
    Customer searchCustomer(Customer customer);
}

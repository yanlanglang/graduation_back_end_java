package com.niit.graduation.repository;

import com.niit.graduation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author Yan Lang
 * @Date 2020/11/13
 * explain:
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    /**
     * 通过username和password 或者 mail和password 查找customer
     * @param username Customer.username
     * @param password  Customer.password
     * @return customer实例
     */
    @Query("select c from Customer c where c.password = ?2 and c.username = ?1  ")
    Customer findCustomer(String username,  String password);

    /**
     * 通过username/mail 查找customer
     * @param username Customer.username
     * @param mail Customer.mail
     * @return customer实例
     */
    Customer findCustomerByUsernameOrMail(String username,String mail);

    /**
     * 通过用户的id修改头像信息
     * 事务注解（Transactional），增删改（Modifying）
     * @return
     */
    @Transactional
    @Modifying
    @Query("update Customer c set c.avatar = ?2 , c.nickname = ?3 , c.mail = ?4 , c.gender = ?5 , c.updateTime = ?6 where c.id = ?1")
    int updateAvatarById(Long id, String avatar, String nickname, String mail, String gender, Date updateTime);






}

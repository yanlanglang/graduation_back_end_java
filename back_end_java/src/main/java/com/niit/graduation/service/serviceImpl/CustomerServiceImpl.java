package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Customer;
import com.niit.graduation.repository.CustomerRepository;
import com.niit.graduation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Yan Lang
 * @Date 2020/11/13
 * explain: Common 的业务接口层
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public boolean insertCustomer(Customer customer) {
        Customer c = customerRepository.findCustomerByUsernameOrMail(customer.getUsername(), customer.getMail());
        if (c==null){
            customerRepository.saveAndFlush(customer);
            return true;
        }else {
            return false;
        }

    }


    @Override
    public Customer editCustomer(Customer customer) {
        customerRepository.updateAvatarById(customer.getId(),
                customer.getAvatar(),
                customer.getNickname(),
                customer.getMail(),
                customer.getGender(),
                customer.getUpdateTime());

        return customerRepository.getOne(customer.getId());
    }

    @Override
    public Customer searchCustomer(Customer customer) {

        return customerRepository.findCustomer(customer.getUsername(), customer.getPassword());
    }


}

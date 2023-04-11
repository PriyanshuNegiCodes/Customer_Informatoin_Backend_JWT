package com.example.CustomerInformation.Services;

import com.example.CustomerInformation.Domain.Customer;
import com.example.CustomerInformation.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String customerName) {
        return customerRepository.findById(customerName).get();
    }
}

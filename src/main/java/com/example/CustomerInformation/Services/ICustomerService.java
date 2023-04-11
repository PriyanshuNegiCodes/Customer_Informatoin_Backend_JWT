package com.example.CustomerInformation.Services;

import com.example.CustomerInformation.Domain.Customer;
import com.example.CustomerInformation.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    Customer addCustomer(Customer customer);
    Customer getCustomerById(String customerName);
}

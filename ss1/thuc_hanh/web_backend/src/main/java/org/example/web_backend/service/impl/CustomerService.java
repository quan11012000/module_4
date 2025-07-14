package org.example.web_backend.service.impl;

import org.example.web_backend.entity.Customer;
import org.example.web_backend.repository.CustomerRepository;
import org.example.web_backend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
//    Filed DI. Ngoài ra còn constructor DI, Setter DI
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }
    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}

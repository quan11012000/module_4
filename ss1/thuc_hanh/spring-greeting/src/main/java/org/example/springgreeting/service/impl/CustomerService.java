package org.example.springgreeting.service.impl;

import org.example.springgreeting.entity.Customer;
import org.example.springgreeting.repository.CustomerRepository;
import org.example.springgreeting.service.ICustomerService;
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
}

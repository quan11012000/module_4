package org.example.web_backend.repository;
import org.example.web_backend.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customers.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customers.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
        customers.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
        customers.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Việt Nam"));
    }

    public List<Customer> findAll() {
        return customers;
    }

    public boolean add(Customer customer) {
        customers.add(customer);
        return true;
    }
    public Customer findById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}

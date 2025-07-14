package org.example.springgreeting.repository;
import org.example.springgreeting.entity.Customer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "HaiTT", "123456789", 100, "Diamond"));
    }

    public List<Customer> findAll() {
        return customers;
    }

    public boolean add(Customer customer) {
        customers.add(customer);
        return true;
    }
}

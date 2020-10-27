package ua.alvin.springdemo.dao;

import ua.alvin.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {



    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    List<Customer> getCustomers();

    void deleteCustomer(Customer customer);

    void deleteCustomer(int theId);

    List<Customer> searchCustomer(String theSearchName);
}

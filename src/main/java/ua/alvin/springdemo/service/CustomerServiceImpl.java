package ua.alvin.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alvin.springdemo.dao.CustomerDAO;
import ua.alvin.springdemo.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

        customerDAO.saveCustomer(customer);

    }

  /*  @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }*/

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomer(String theSearchName) {
        return customerDAO.searchCustomer(theSearchName);
    }
}

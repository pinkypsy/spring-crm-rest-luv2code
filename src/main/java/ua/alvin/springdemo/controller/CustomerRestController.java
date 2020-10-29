package ua.alvin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.alvin.springdemo.entity.Customer;
import ua.alvin.springdemo.exception.CustomerNotFoundException;
import ua.alvin.springdemo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;
//    private List<Customer> customers;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId){

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) throw new CustomerNotFoundException("There is no such customer with id #" + customerId);

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);

        return customer;

    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer tempCustomer = customerService.getCustomer(customerId);

        if (tempCustomer == null)
            throw new CustomerNotFoundException("There is no such customer with id #" + customerId);

        customerService.deleteCustomer(customerId);
        return "Deleted customer with id #" + customerId;
    }
}

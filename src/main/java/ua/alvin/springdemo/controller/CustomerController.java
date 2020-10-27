package ua.alvin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.alvin.springdemo.entity.Customer;
import ua.alvin.springdemo.service.CustomerService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject customer service layer which contains customerDAO and
    // delegates it work with customerList
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        //get customerList list from Service
        List<Customer> customerList = customerService.getCustomers();
        //add customerList to the model
        model.addAttribute("customerList", customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @GetMapping("/showFormUpdateCustomer")
    public String showFormUpdateCustomer(@RequestParam("customerId") int theId, Model model){

        Customer theCustomer = customerService.getCustomer(theId);

        model.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        Customer customer = customerService.getCustomer(theId);

//или так
//        customerService.deleteCustomer(customer);

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @PostMapping("/saveCustomer")//information received from HTML form defined where action="saveCustomer" mentioned
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
                               BindingResult theBindingResult) {
        System.out.println(1);
        customerService.saveCustomer(customer);
        System.out.println(1);

        if (theBindingResult.hasErrors()) return "customer-form";
        else {
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model model){

        List <Customer> customerList = customerService.searchCustomer(theSearchName);

        model.addAttribute("customerList", customerList);

        return "list-customers";
    }








//@Value("#{T(java.util.Arrays).asList(orderByOptions['orderByOptions'])}")
//private ArrayList<String> orderByOptions;
//  in method:   model.addAttribute("orderByOptions", orderByOptions);


 /*   @GetMapping("/showFormUpdateCustomer")
    public String showFormUpdateCustomer(Model model){
model.addAttribute("customer", new Customer());
        return "customer-update-form";
    }*/




 /*   @PostMapping("/updateCustomer")
    public String showFormUpdateCustomer(@ModelAttribute("customer")Customer theCustomer,
                                         BindingResult theBindingResult){

        if (theBindingResult.hasErrors()) return "customer-form";
        else return "redirect:/customer/list";

    }*/


}

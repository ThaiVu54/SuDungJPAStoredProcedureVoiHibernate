package com.thai.customers.controller;

import com.thai.customers.model.Customer;
import com.thai.customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer(@ModelAttribute ("customer") Customer customer){
        customerService.insertWithStoredProcedure(customer);
        //procedure
        // create
        //    definer = root@localhost procedure insert_customer(IN first_name varchar(255), IN last_name varchar(255))
        //begin
        //    insert into customers(firstName,lastName) values (first_name,last_name);
        //end;
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message","them thanh cong");
        return modelAndView;
    }
}

package com.springframework.springmvc.controllers;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/27/2022 9:46 PM
*/

import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customer/customerList";
    }

    @RequestMapping("/display/{id}")
    public String displayCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerDisplay";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerForm";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer) {
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        System.out.println(savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/display/" + savedCustomer.getId();
    }
}

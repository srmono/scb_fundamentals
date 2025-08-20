package com.scb.bankapp.controller;

import com.scb.bankapp.model.Customer;
import com.scb.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

//    @RequestMapping("/hello")
//    public  String getMessage(){
//        return  "Welcome to Customer App";
//    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return  customerService.getCustomerBYId(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer
    ){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public  void  deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

}

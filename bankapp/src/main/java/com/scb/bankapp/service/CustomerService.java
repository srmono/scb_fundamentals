package com.scb.bankapp.service;

import com.scb.bankapp.exception.CustomerNotFoundException;
import com.scb.bankapp.model.Customer;
import com.scb.bankapp.respository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional(readOnly = true)
public class CustomerService {

    @Autowired
    private CustomerRepository crepo;

    public List<Customer> getAllCustomers(){
        return crepo.findAll();
    }

    public Customer getCustomerBYId(int id){
        return  crepo.findById(id)
                    .orElseThrow(
                            () -> new CustomerNotFoundException(
                                "Customer with ID " + id + " not found"
                        ));
    }

    @Transactional
    public Customer addCustomer(Customer customer) {

        crepo.findByEmail(customer.getEmail()).ifPresent(c -> {
            throw new IllegalArgumentException("Email already exists: " + c.getEmail());
        });

        return crepo.save(customer);
    }

    public void deleteCustomer (int id){
        if(!crepo.existsById(id)){
            throw  new CustomerNotFoundException(
                    "Customer with ID " + id + " not found"
            );
        }

        crepo.deleteById(id);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer){
        Customer existing = crepo.findById(id)
                                    .orElseThrow(
                                        () -> new CustomerNotFoundException(
                                                "Customer with ID " + id + " not found"
                                    ));

        existing.setEmail(updatedCustomer.getEmail());
        existing.setPhone(updatedCustomer.getPhone());
        existing.setFirstName(updatedCustomer.getFirstName());
        existing.setLastName(updatedCustomer.getLastName());

        return crepo.save(existing);
    }





    //private List<Customer> customers;
//    public CustomerService(){
//        Customer one = new Customer(1,"Priya","b","pri@gmail.com","7204772949");
//        Customer two = new Customer(2,"Shreya","c","ahre@gmail.com","7202572949");
//        Customer three = new Customer(3,"Sri","d","siri@gmail.com","6834772949");
//
//        customers=new ArrayList<Customer>();
//        customers.add(one);
//        customers.add(two);
//        customers.add(three);
//    }

//    public List<Customer> getAllCustomers(){
//        return  customers;
//    }
//
//    //GetCustomer By id
//    public Customer getCustomerBYId(int id){
//        return  customers.stream()
//                .filter(c -> c.getId() == id)
//                .findFirst()
//                .orElseThrow(
//                        () -> new CustomerNotFoundException(
//                                "Customer with ID " + id + " not found"
//                        )
//                );
//    }
//
//    //AddCustomer
//    public void addCustomer(Customer customer){
//        customers.add(customer);
//    }
//
//    //deleteCustomer
//    public void deleteCustomer(int id){
//        boolean removed =  customers.removeIf(c -> c.getId() == id);
//        if(!removed) {
//            throw  new CustomerNotFoundException(
//                    "Can't delete customer with  ID " + id + " not found"
//            );
//        }
//    }
////    public void deleteCustomer(int id){
////        for(Customer customer:customers){
////            if(customer.getId() == id){
////                customers.remove(customer);
////            }
////        }
////
////    }
//
//
//
//    //update customer by id
//    public void updateCustomer(int id, Customer updatedCustomer){
//        for (int i =0; i < customers.size(); i++) {
//            if(customers.get(i).getId() == id){
//                customers.set(i, updatedCustomer);
//                return;
//            }
//        }
//
//    }

}

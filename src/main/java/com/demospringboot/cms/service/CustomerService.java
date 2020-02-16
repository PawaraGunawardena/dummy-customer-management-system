package com.demospringboot.cms.service;

import com.demospringboot.cms.dao.CustomerDAO;
import com.demospringboot.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    private int customerIdCount = 1;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer)
    {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers()
    {
//        return customerList;
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId)
    {
//        return customerList.stream().filter(c->c.getCustomerId() == customerId).findFirst().get();

        return customerDAO.findById(customerId). // this returns the optional object
                get();//this give the correct customer
    }

    public Customer updateCustomer(int customerId, Customer customer)
    {
//        customerList.stream().
//                forEach(
//                    c-> {
//                        if(c.getCustomerId() == customerId)
//                        {
//                            c.setCustomerFirstName(customer.getCustomerFirstName());
//                            c.setCustomerSecondName(customer.getCustomerSecondName());
//                            c.setCustomerEmail(customer.getCustomerEmail());
//                        }
//                    }
//                );
//
//        return customerList.stream().filter(c->c.getCustomerId() == customerId).findFirst().get();

        customer.setCustomerId(customerId);
        return customerDAO.save(customer);

    }

    public void deleteCustomer(int customerId)
    {
//        customerList.stream().
//                forEach(
//                        c-> {
//                            if(c.getCustomerId() == customerId)
//                            {
//                                customerList.remove(c);
//                            }
//                        }
//                );

        customerDAO.deleteById(customerId);
    }
}

package com.demospringboot.cms.api;

import com.demospringboot.cms.model.Customer;
import com.demospringboot.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")//if client send this url, this class will be triggered
public class CustomerResource
{
    @Autowired //enable using the customer service class functions by autowired annotation
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(
            @RequestBody // pass the customer json and it will convert to customer object
            Customer customer)
    {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId)
    {
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer)
    {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId)
    {
        customerService.deleteCustomer(customerId);
    }
}

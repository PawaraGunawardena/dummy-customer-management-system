package com.demospringboot.cms.dao;

import com.demospringboot.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends CrudRepository<
        Customer, //type of the class dealing with
        Integer>  // id type of the entity
{
}

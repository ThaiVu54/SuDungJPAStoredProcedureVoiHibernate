package com.thai.customers.service;

import com.thai.customers.model.Customer;
import com.thai.customers.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {

        return customerRepo.insertWithStoredProcedure(customer);
    }
}

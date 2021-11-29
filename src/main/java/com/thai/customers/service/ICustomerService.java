package com.thai.customers.service;

import com.thai.customers.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}

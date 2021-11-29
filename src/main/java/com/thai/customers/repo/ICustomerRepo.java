package com.thai.customers.repo;

import com.thai.customers.model.Customer;

public interface ICustomerRepo {
    boolean insertWithStoredProcedure(Customer customer);
}

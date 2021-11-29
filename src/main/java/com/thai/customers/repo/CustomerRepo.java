package com.thai.customers.repo;

import com.thai.customers.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CustomerRepo implements ICustomerRepo{
    @PersistenceContext
    private EntityManager em;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String s = "call insert_customer(:firstName,:lastName)";
        Query query = em.createNativeQuery(s);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        return query.executeUpdate()==0;
    }
}

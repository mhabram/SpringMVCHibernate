package com.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    //Injecting sessionFactory
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Customer> getCustomers() {
        //Current hibernate session
        Session session = sessionFactory.getCurrentSession();
        
        //Query and sort by last name
        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        
        //Execute query, get result
        List<Customer> customers = query.getResultList();
        
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        //Current hibernate session
        Session session = sessionFactory.getCurrentSession();
        
        //save the customer
        session.save(customer);
        
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        
        Customer customer = session.get(Customer.class, id);
        
        return customer;
    }

}

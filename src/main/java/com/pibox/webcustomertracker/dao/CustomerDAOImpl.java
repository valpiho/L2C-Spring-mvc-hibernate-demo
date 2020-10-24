package com.pibox.webcustomertracker.dao;

import com.pibox.webcustomertracker.config.HibernateUtils;
import com.pibox.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public List<Customer> getCustomers() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer order by lastName");
        List<Customer> customerList = customerQuery.getResultList();
        session.close();
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Customer customer = session.find(Customer.class, id);
        session.close();
        return customer;
    }
}

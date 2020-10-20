package com.pibox.webcustomertracker.dao;

import com.pibox.webcustomertracker.config.HibernateUtils;
import com.pibox.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer");
        List<Customer> customerList = customerQuery.getResultList();
        session.close();
        return customerList;
    }
}

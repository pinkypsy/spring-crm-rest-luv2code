package ua.alvin.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.springdemo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get current HB session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> customerQuery =
                currentSession.createQuery("from Customer", Customer.class);

        //execute query and get result list
        List<Customer> customers = customerQuery.getResultList();

        //return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println(3);

        Session session = sessionFactory.getCurrentSession();
        //save if there is no customer with such id, update otherwise
        session.saveOrUpdate(customer);

        System.out.println(3);

    }

  /*  @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        int id = customer.getId();
        Query <Customer> query =
                session.createQuery(
                        "update Customer set first_name = 'customer.getFirstName()' where id = 1", Customer.class);
    }*/

    @Override
    public Customer getCustomer(int theId) {

        Session session = sessionFactory.getCurrentSession();
        
        return session.get(Customer.class, theId);

    }

    @Override
    public void deleteCustomer(Customer customerToDelete) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(customerToDelete);

    }

    @Override
    public void deleteCustomer(int theId) {
        //or delete with primary key:
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId", theId);

        query.executeUpdate();

    }

    @Override
    public List<Customer> searchCustomer(String theSearchName) {

        Session session = sessionFactory.getCurrentSession();

        Query <Customer> query = null;

        if (theSearchName != null && theSearchName.trim().length() > 0) {
            query = session.createQuery(
                    "from Customer where lower(firstName) like :theName or " +
                            "lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", ("%" + theSearchName.toLowerCase() + "%"));
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }

        List <Customer> customerList = query.getResultList();

        return customerList;
    }


}

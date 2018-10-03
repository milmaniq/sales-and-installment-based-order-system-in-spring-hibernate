/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rj.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.ijse.rj.dao.CrudDAOImpl;
import lk.ijse.rj.dao.custom.OrderDAO;
import lk.ijse.rj.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ilman Iqbal
 */
@Component
public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Order> getOrderByOrderId(String id) throws Exception {
        return getSession().createQuery("FROM Order o WHERE o.orderId LIKE ?1 " +
                "ORDER BY cast(substring(o.orderId,2) as integer) DESC")
                .setParameter(1, id)
                .list();
    }

    @Override
    public List<Order> getOrderByName(String name) throws Exception {
        return getSession().createQuery("FROM Order o WHERE o.name LIKE ?1 " +
                "ORDER BY cast(substring(o.orderId,2) as integer) DESC")
                .setParameter(1, name)
                .list();
    }

    @Override
    public List<Order> getOrderByContact(String contact) throws Exception {
        return getSession().createQuery("FROM Order o WHERE o.contact LIKE ?1 " +
                "ORDER BY cast(substring(o.orderId,2) as integer) DESC")
                .setParameter(1, contact)
                .list();
    }

    @Override
    public List<Object[]> getOrderByDateOfOrder(String dateOrder) throws Exception {
        return getSession().createNativeQuery("SELECT orderId, `name`, address, contact, dateOfOrder," +
                "dateOfDelivery, total, buyGold, advance, netTotal, balance," +
                "dateOfActualDelivery, dateOfCancellation, employeeId " +
                "FROM `Order` o WHERE o.dateOfOrder LIKE ?1 " +
                "ORDER BY convert(substring(o.orderId,2),signed integer) DESC")
                .setParameter(1, dateOrder)
                .list();
    }

    @Override
    public List<Object[]> getOrderByDateOfDelivery(String dateDelivery) throws Exception {
        return getSession().createNativeQuery("SELECT orderId, `name`, address, contact, dateOfOrder," +
                "dateOfDelivery, total, buyGold, advance, netTotal, balance," +
                "dateOfActualDelivery, dateOfCancellation, employeeId " +
                "FROM `Order` o WHERE o.dateOfDelivery LIKE ?1 " +
                "ORDER BY convert(substring(o.orderId,2),signed integer) DESC")
                .setParameter(1, dateDelivery)
                .list();
    }

    @Override
    public void updateBalanceByOrderId(Order orderId) throws Exception {
        getSession().createNativeQuery("UPDATE `Order` SET balance = ?1 WHERE orderId = ?2")
                .setParameter(1, orderId.getBalance())
                .setParameter(2, orderId.getOrderId())
                .executeUpdate();
    }


    @Override
    public void updateDateOfActualDeliveryByOrderId(Order orderId) throws Exception {
        getSession().createNativeQuery("UPDATE `Order` SET dateOfActualDelivery=?1 WHERE orderId=?2")
                .setParameter(1, orderId.getDateOfActualDelivery())
                .setParameter(2, orderId.getOrderId())
                .executeUpdate();
    }

    ////////checked upto here


}

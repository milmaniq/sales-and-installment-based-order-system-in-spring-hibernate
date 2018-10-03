/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rj.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lk.ijse.rj.dao.CrudDAOImpl;
import lk.ijse.rj.dao.custom.OrderItemDAO;
import lk.ijse.rj.entity.Order;
import lk.ijse.rj.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ilman Iqbal
 */
@Component
public class OrderItemDAOImpl extends CrudDAOImpl<OrderItem, String> implements OrderItemDAO{
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<OrderItem> getOrderItemsByOrder(Order order) throws Exception {

        return getSession().createQuery("FROM OrderItem oi WHERE oi.order=?1")
                .setParameter(1, order)
                .list();

    }
    
///////////checked upto here
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rj.dao.custom.impl;


import java.util.List;
import lk.ijse.rj.dao.custom.QueryDAO;
import lk.ijse.rj.entity.Stock;
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
public class QueryDAOImpl implements QueryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<Stock> getAvailableStockDetail() throws Exception {
        List<Stock> rst = getSession().createNativeQuery("SELECT s.itemId, s.description, weight, rate, dateAdded\n"
                + "FROM stock s\n"
                + "LEFT JOIN saleitem si\n"
                + "ON s.itemId = si.itemId\n"
                + "LEFT JOIN orderitem oi\n"
                + "ON s.itemId = oi.itemId\n"
                + "WHERE si.itemId IS NULL AND oi.itemId IS NULL\n"
                + "ORDER BY s.itemId ASC")
                .setResultTransformer(Transformers.aliasToBean(Stock.class))
                .list();

        return rst;

    }


}
    
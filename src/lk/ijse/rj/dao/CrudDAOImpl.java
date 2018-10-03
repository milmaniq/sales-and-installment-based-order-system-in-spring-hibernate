package lk.ijse.rj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CrudDAOImpl<T,ID> implements CrudDAO<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entity;

    public CrudDAOImpl() {
        entity = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(T entity) throws Exception {
        getSession().persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        getSession().update(entity);
    }

    @Override
    public void delete(ID id) throws Exception {

        if(entity.getName() == "lk.ijse.rj.entity.OrderBalancePayment"){
            T t = getSession().find(entity, Integer.valueOf(id.toString()));
            getSession().remove(t);
            return;
        }

        T t = getSession().find(entity, id);
        getSession().remove(t);
    }

    @Override
    public T find(ID id) throws Exception {
        return getSession().find(entity, id);
    }

    @Override
    public List<T> getAll() throws Exception {
        return getSession().createQuery("FROM " + entity.getName()).list();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rj.dao;

import org.hibernate.Session;

/**
 *
 * @author Ilman Iqbal
 */
public interface SuperDAO {
    Session getSession();
}
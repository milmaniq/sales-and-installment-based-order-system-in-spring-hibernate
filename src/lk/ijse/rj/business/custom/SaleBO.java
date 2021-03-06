/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rj.business.custom;

import java.util.ArrayList;
import java.util.Date;

import lk.ijse.rj.business.SuperBO;
import lk.ijse.rj.dto.OrderDTO;
import lk.ijse.rj.dto.SaleDTO;
import lk.ijse.rj.dto.SaleItemDTO;

/**
 *
 * @author Ilman Iqbal
 */
public interface SaleBO extends SuperBO{
    public boolean insertSale(SaleDTO dto) throws Exception;
    
    public boolean updateSale(SaleDTO dto) throws Exception;
    
    public ArrayList<SaleDTO> getAllSales() throws Exception;
    
    public SaleDTO findSale(String id) throws Exception;
    
    public ArrayList<SaleDTO> getSaleBySaleId(String id) throws Exception;
    
    public ArrayList<SaleDTO> getSaleByName(String name) throws Exception;
    
    public ArrayList<SaleDTO> getSaleByContact(String contact) throws Exception;
    
    public ArrayList<SaleDTO> getSaleByDateOfSale(String date) throws Exception;
    
    public ArrayList<SaleDTO> getSaleByOrderId(String orderId) throws Exception;
    
    public ArrayList<SaleItemDTO> getSaleItemBySaleId(String saleId) throws Exception;
    
    
}

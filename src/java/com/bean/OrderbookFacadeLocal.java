/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.entity.Orderbook;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Le Thi Minh Loan
 */
@Local
public interface OrderbookFacadeLocal {

    void create(Orderbook orderbook);

    void edit(Orderbook orderbook);

    void remove(Orderbook orderbook);

    Orderbook find(Object id);

    List<Orderbook> findAll();

    List<Orderbook> findRange(int[] range);

    int count();
    
}

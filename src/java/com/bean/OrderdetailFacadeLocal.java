/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.entity.Orderdetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Le Thi Minh Loan
 */
@Local
public interface OrderdetailFacadeLocal {

    void create(Orderdetail orderdetail);

    void edit(Orderdetail orderdetail);

    void remove(Orderdetail orderdetail);

    Orderdetail find(Object id);

    List<Orderdetail> findAll();

    List<Orderdetail> findRange(int[] range);

    int count();
    
}

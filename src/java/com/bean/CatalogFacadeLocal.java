/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.entity.Catalog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Le Thi Minh Loan
 */
@Local
public interface CatalogFacadeLocal {

    void create(Catalog catalog);

    void edit(Catalog catalog);

    void remove(Catalog catalog);

    Catalog find(Object id);

    List<Catalog> findAll();

    List<Catalog> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.entity.Publisher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Le Thi Minh Loan
 */
@Local
public interface PublisherFacadeLocal {

    void create(Publisher publisher);

    void edit(Publisher publisher);

    void remove(Publisher publisher);

    Publisher find(Object id);

    List<Publisher> findAll();

    List<Publisher> findRange(int[] range);

    int count();
    
}

package com.bean;

import com.entity.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Le Thi Minh Loan
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {
    @PersistenceContext(unitName = "CUSCShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

}

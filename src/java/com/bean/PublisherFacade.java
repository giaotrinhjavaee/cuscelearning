package com.bean;

import com.entity.Publisher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Le Thi Minh Loan
 */
@Stateless
public class PublisherFacade extends AbstractFacade<Publisher> implements PublisherFacadeLocal {
    @PersistenceContext(unitName = "CUSCShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublisherFacade() {
        super(Publisher.class);
    }

}

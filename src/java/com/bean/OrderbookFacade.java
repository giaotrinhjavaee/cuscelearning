package com.bean;

import com.entity.Orderbook;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Le Thi Minh Loan
 */
@Stateless
public class OrderbookFacade extends AbstractFacade<Orderbook> implements OrderbookFacadeLocal {
    @PersistenceContext(unitName = "CUSCShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderbookFacade() {
        super(Orderbook.class);
    }

}

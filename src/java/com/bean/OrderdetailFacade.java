package com.bean;

import com.entity.Orderdetail;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Le Thi Minh Loan
 */
@Stateless
public class OrderdetailFacade extends AbstractFacade<Orderdetail> implements OrderdetailFacadeLocal {
    @PersistenceContext(unitName = "CUSCShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderdetailFacade() {
        super(Orderdetail.class);
    }

}

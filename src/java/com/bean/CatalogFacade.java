package com.bean;

import com.entity.Catalog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Le Thi Minh Loan
 */
@Stateless
public class CatalogFacade extends AbstractFacade<Catalog> implements CatalogFacadeLocal {
    @PersistenceContext(unitName = "CUSCShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogFacade() {
        super(Catalog.class);
    }

}

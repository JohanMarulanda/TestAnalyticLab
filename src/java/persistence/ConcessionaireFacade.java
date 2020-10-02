/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Bus;
import models.Concessionaire;
import models.Device;
import models.DeviceType;


/**
 *
 * @author Johan
 */
@Stateless
public class ConcessionaireFacade extends AbstractFacade<Concessionaire> implements ConcessionaireFacadeLocal {

    @PersistenceContext(unitName = "TestAnalyticPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcessionaireFacade() {
        super(Concessionaire.class);
    }
    
    @Override
    public List<Bus> listBusesC1() {
        String consulta = "SELECT b FROM Bus b WHERE "
                + " b.concessionaireId.id = 1";
        try {
            Query query = em.createQuery(consulta);
            return (List<Bus>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import models.Bus;
import models.Concessionaire;
import models.Device;
import models.DeviceType;

/**
 *
 * @author Johan
 */
@Local
public interface ConcessionaireFacadeLocal {

    void create(Concessionaire concessionaire);

    void edit(Concessionaire concessionaire);

    void remove(Concessionaire concessionaire);

    Concessionaire find(Object id);

    List<Concessionaire> findAll();

    List<Concessionaire> findRange(int[] range);

    int count();
    
    List<Bus> listBusesC1();
    
}

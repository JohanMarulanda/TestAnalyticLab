/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import models.Bus;
import models.Concessionaire;
import models.Device;

/**
 *
 * @author Johan
 */
@Local
public interface Concesionari_logicLocal {
    public Concessionaire find(Integer id) throws Exception;

    public List<Bus> listBusesC1();

    public List<Bus> All() throws Exception;

    public List<Device> findDevicesBNVR();
    public List<Device> sumaryDevice();
    public List<Bus> sumaryBus();
    
}

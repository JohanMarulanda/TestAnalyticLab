/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import models.Bus;
import models.Concessionaire;
import models.Device;
import models.DeviceType;
import persistence.BusFacadeLocal;
import persistence.ConcessionaireFacadeLocal;
import persistence.DeviceFacadeLocal;
import persistence.DeviceTypeFacadeLocal;



/**
 *
 * @author Johan
 */
@Stateless
public class Concesionari_logic implements Concesionari_logicLocal {
    @EJB
    private ConcessionaireFacadeLocal concessDAO;
    @EJB
    private BusFacadeLocal busDAO;
    @EJB
    private DeviceFacadeLocal deviceDAO;
   
    public ConcessionaireFacadeLocal getConcessionariDAO() {
        return concessDAO;
    }

    @Override
    public List<Bus> All() throws Exception {
        return busDAO.findAll();
    }

    @Override
    public Concessionaire find(Integer id) throws Exception {
        return concessDAO.find(id);
    }

    @Override
    public List<Bus> listBusesC1() {
        return concessDAO.listBusesC1();
    }

    @Override
    public List<Device> findDevicesBNVR() {
        List<Bus> b = busDAO.findWhereType("Bi-articulado");

        String lista = b.stream()
                .map((x) -> String.valueOf(x.getId()))
                .collect(Collectors.joining(","));

        return deviceDAO.findDevicesBNVR(lista);
    }

    @Override
    public List<Device> sumaryDevice() {
        return deviceDAO.summaryDevice();
    }

    @Override
    public List<Bus> sumaryBus() {
        return busDAO.summaryBus();
    }
    
}

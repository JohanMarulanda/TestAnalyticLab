/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logic.Concesionari_logicLocal;
import models.Bus;
import models.Device;

/**
 *
 * @author Johan
 */
public class ConcessionarieBean {

   private List<Bus> busList;
    private List<Device> deviceList;
    private List<Device> summaryDeviceList;
    private List<Bus> summaryBusList;

    @EJB
    private Concesionari_logicLocal concessLogic;

    /**
     * Creates a new instance of ConcessionaireView
     */
    public ConcessionarieBean() {
    }

    public List<Bus> getBusList() throws Exception {
        busList = concessLogic.listBusesC1();
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public List<Device> getDeviceList() {
        deviceList = concessLogic.findDevicesBNVR();
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public List<Device> getSummaryDeviceList() {
        summaryDeviceList = concessLogic.sumaryDevice();
        return summaryDeviceList;
    }

    public void setSummaryDeviceList(List<Device> summaryDeviceList) {
        this.summaryDeviceList = summaryDeviceList;
    }

    public List<Bus> getSummaryBusList() {
        summaryBusList = concessLogic.sumaryBus();
        return summaryBusList;
    }

    public void setSummaryBusList(List<Bus> summaryBusList) {
        this.summaryBusList = summaryBusList;
    }

    public Concesionari_logicLocal getConcessLogic() {
        return concessLogic;
    }

    public void setConcessLogic(Concesionari_logicLocal concessLogic) {
        this.concessLogic = concessLogic;
    }
}

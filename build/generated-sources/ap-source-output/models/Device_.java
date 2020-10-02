package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Bus;
import models.DeviceType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T15:03:30")
@StaticMetamodel(Device.class)
public class Device_ { 

    public static volatile SingularAttribute<Device, Bus> busId;
    public static volatile SingularAttribute<Device, DeviceType> deviceTypeId;
    public static volatile SingularAttribute<Device, String> ip;
    public static volatile SingularAttribute<Device, Integer> id;
    public static volatile SingularAttribute<Device, Short> status;

}
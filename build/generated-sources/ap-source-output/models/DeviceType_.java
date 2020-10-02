package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Device;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T15:03:30")
@StaticMetamodel(DeviceType.class)
public class DeviceType_ { 

    public static volatile SingularAttribute<DeviceType, String> name;
    public static volatile ListAttribute<DeviceType, Device> deviceList;
    public static volatile SingularAttribute<DeviceType, Integer> id;

}
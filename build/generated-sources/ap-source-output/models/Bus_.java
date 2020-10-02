package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Concessionaire;
import models.Device;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T15:03:30")
@StaticMetamodel(Bus.class)
public class Bus_ { 

    public static volatile SingularAttribute<Bus, String> motor;
    public static volatile SingularAttribute<Bus, Concessionaire> concessionaireId;
    public static volatile SingularAttribute<Bus, String> brakes;
    public static volatile ListAttribute<Bus, Device> deviceList;
    public static volatile SingularAttribute<Bus, Integer> id;
    public static volatile SingularAttribute<Bus, String> type;

}
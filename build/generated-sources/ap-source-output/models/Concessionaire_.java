package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Bus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T15:03:30")
@StaticMetamodel(Concessionaire.class)
public class Concessionaire_ { 

    public static volatile SingularAttribute<Concessionaire, String> name;
    public static volatile SingularAttribute<Concessionaire, Integer> id;
    public static volatile ListAttribute<Concessionaire, Bus> busList;

}
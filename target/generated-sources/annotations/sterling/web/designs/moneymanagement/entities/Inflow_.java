package sterling.web.designs.moneymanagement.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T13:25:35")
@StaticMetamodel(Inflow.class)
public class Inflow_ { 

    public static volatile SingularAttribute<Inflow, Date> date;
    public static volatile SingularAttribute<Inflow, Integer> amount;
    public static volatile SingularAttribute<Inflow, String> inflowid;
    public static volatile SingularAttribute<Inflow, String> transid;
    public static volatile SingularAttribute<Inflow, String> approvedby;
    public static volatile SingularAttribute<Inflow, String> currency;
    public static volatile SingularAttribute<Inflow, Date> time;
    public static volatile SingularAttribute<Inflow, String> type;
    public static volatile SingularAttribute<Inflow, String> enteredby;
    public static volatile SingularAttribute<Inflow, String> status;

}
package sterling.web.designs.moneymanagement.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T13:25:35")
@StaticMetamodel(Outflow.class)
public class Outflow_ { 

    public static volatile SingularAttribute<Outflow, String> requestedby;
    public static volatile SingularAttribute<Outflow, Integer> amount;
    public static volatile SingularAttribute<Outflow, Date> dateIntiated;
    public static volatile SingularAttribute<Outflow, Integer> cashoutid;
    public static volatile SingularAttribute<Outflow, String> approvedby;
    public static volatile SingularAttribute<Outflow, String> currency;
    public static volatile SingularAttribute<Outflow, String> designation;
    public static volatile SingularAttribute<Outflow, Date> dateResponse;
    public static volatile SingularAttribute<Outflow, String> type;
    public static volatile SingularAttribute<Outflow, String> status;

}
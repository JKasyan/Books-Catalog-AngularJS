package catalog.angularjs.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Created by Victoriya on 26.01.16.
 */
public class HibernateAwareObjectMapper extends ObjectMapper{

    public HibernateAwareObjectMapper(){
        Hibernate4Module hb = new Hibernate4Module();
        registerModule(hb);
    }
}

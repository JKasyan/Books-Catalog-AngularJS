package catalog.angularjs.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Victoriya on 26.01.16.
 */
//@Configuration
public class ConverterConfig {

//    @Bean
    public JacksonConverter jacksonConverter(){
        JacksonConverter jc = new JacksonConverter();
        jc.setObjectMapper(hibernateAwareObjectMapper());
        return jc;
    }

//    @Bean
    public HibernateAwareObjectMapper hibernateAwareObjectMapper() {
        return new HibernateAwareObjectMapper();
    }
}

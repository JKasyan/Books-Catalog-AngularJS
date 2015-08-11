package catalog.angularjs.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * Created by evgen on 11.08.15.
 */

@Configuration
public class MongoConfig {

    @Bean
    public DB getDB() throws UnknownHostException{
        String uri = "mongodb://Evgen:password@id.mongolab.com:53178/db";//!!!!!
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        MongoClient client = new MongoClient(mongoClientURI);
        DB db = client.getDB(mongoClientURI.getDatabase());
        db.authenticate(mongoClientURI.getUsername(),mongoClientURI.getPassword());
        return db;
    }
}

package peaksoft.configuration;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.Laptop;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

public class DBConnection {
    public static EntityManagerFactory createEntityManagerFactory(){
        Properties properties = new Properties();
//        properties.setProperty("org.hibernate.driver_class","org.postgresql.Driver");  -- Еще вариант...
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/book");
        properties.setProperty(Environment.USER,"postgres");
        properties.setProperty(Environment.PASS,"postgres00");

        properties.setProperty(Environment.HBM2DDL_AUTO,"create");
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");
        properties.setProperty(Environment.FORMAT_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Laptop.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}

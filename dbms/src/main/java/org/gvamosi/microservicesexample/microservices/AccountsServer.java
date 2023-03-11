package org.gvamosi.microservicesexample.microservices;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.gvamosi.microservicesexample.microservices.cassandra.CassandraConfig;
import org.gvamosi.microservicesexample.microservices.repositories.AccountsRepository;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsConfiguration}. This is a deliberate separation of concerns.
 * <p>
 * This class declares no beans and current package contains no components for
 * ComponentScan to find.
 * 
 * @author Paul Chapman, Gergely Vamosi
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class })
@EnableDiscoveryClient
@Import({ CassandraConfig.class })
public class AccountsServer {

    @Autowired
    protected AccountsRepository accountRepository;

    protected Logger logger = Logger.getLogger(AccountsServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     * 
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}
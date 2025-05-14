package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * Entry point for Eureka Server application.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

//    @Autowired
//    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @EventListener(ContextClosedEvent.class)
    public void onShutdown() {
        System.out.println("Shutting down Eureka Server gracefully...");

        // Properly unregister the Eureka Client before shutting down
//        if (eurekaClient != null) {
//            eurekaClient.shutdown();
//        }
    }
}

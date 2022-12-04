package com.academy.nacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NacosConfigApplication.class, args);
        /*while (true){
            String username = context.getEnvironment().getProperty("user.name");
            String profileAcvtiveUsername = context.getEnvironment().getProperty("profile.active.user.name");
            String commonUsername1 = context.getEnvironment().getProperty("common1.user.name");
            String commonUsername2 = context.getEnvironment().getProperty("common2.user.name");
            String sharedUsername1 = context.getEnvironment().getProperty("shared1.user.name");
            String sharedUsername2 = context.getEnvironment().getProperty("shared2.user.name");
            System.out.println("username=" + username + "; profileAcvtiveUsername="+ profileAcvtiveUsername + "; commonUsername1="+ commonUsername1+ "; commonUsername2="+ commonUsername2 + "; sharedUsername1="+ sharedUsername1+ "; sharedUsername2="+ sharedUsername2) ;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
    }

}

package com.hunsblog.sounghun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SounghunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SounghunApplication.class, args);
    }

}

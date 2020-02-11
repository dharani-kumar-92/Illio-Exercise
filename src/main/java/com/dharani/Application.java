package com.dharani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//    UriComponents uriComponents = UriComponentsBuilder.newInstance()
//            .scheme("http").host("www.baeldung.com").path("/junit-5").build();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

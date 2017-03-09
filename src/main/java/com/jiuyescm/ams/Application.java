/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author litao
 *
 */
@RestController
@SpringBootApplication
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

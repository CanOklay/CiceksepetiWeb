package com.ciceksepeti.logs;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Fatih Can Oklay
 * Date: 30.12.2021
 */

public class Logs {

    public Logs() {
        PropertyConfigurator
                .configure(Logs.class.getClassLoader().getResource("log4j.properties"));
    }
}

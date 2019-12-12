package org.teedjay;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "config")
public class ConfigData {

    public String title;
    public String message;
    public String author;

}

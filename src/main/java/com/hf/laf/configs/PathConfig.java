package com.hf.laf.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Hzldex on 2018/2/22.
 */
@Component
@ConfigurationProperties(prefix = "laf.path")
public class PathConfig {
    private String foundPicPath;
    private String lostPicPath;

    public String getFoundPicPath() {
        return foundPicPath;
    }

    public void setFoundPicPath(String foundPicPath) {
        this.foundPicPath = foundPicPath;
    }

    public String getLostPicPath() {
        return lostPicPath;
    }

    public void setLostPicPath(String lostPicPath) {
        this.lostPicPath = lostPicPath;
    }
}

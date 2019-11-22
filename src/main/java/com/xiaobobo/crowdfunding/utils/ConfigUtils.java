package com.xiaobobo.crowdfunding.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * examConfig.properties
 *
 * @author lm
 */
public class ConfigUtils {
    private static final String LOCATION = "config.properties";

    private static Properties pros = null;

    static {
        String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        System.out.println("path = " + path);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(LOCATION);
        pros = new Properties();

        try {
            pros.load(new InputStreamReader(is, "utf-8"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getProperties(String property) {
        if (property == null || "".equals(property))
            throw new RuntimeException("property key不能为空！");

        return pros.getProperty(property);
    }
}

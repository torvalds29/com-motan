package com.log.tracelog;

import org.slf4j.Logger;

public class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger getLogger(String name) {
        return new TraceLogger(org.slf4j.LoggerFactory.getLogger(name));
    }

    public static Logger getLogger(Class<?> clazz) {
        return new TraceLogger(org.slf4j.LoggerFactory.getLogger(clazz));
    }
}

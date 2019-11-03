package com.log.tracelog;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * 该日志器用来生成与打印跨应用traceId, 输出的方法与原logger保持相同
 */
public class TraceLogger implements Logger {
    private final Logger logger;
    private final String left = "[";
    private final String right = "] - ";

    public TraceLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        logger.trace(getMsg(msg));
    }

    private String getFormat(String format) {
        return getMsg(format);
    }

    /**
     * 封装traceId到日志中
     *
     * @param msg
     * @return
     */
    private String getMsg(String msg) {
        return new StringBuilder(left).append(TraceUtl.getTraceId()).append(right).append(msg).toString();
    }

    @Override
    public void trace(String format, Object arg) {
        logger.trace(getFormat(format), arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        logger.trace(getFormat(format), arg1, arg2);

    }

    @Override
    public void trace(String format, Object... arguments) {
        logger.trace(getFormat(format), arguments);

    }

    @Override
    public void trace(String msg, Throwable t) {
        logger.trace(getMsg(msg), t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        logger.trace(marker, getMsg(msg));
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        logger.trace(marker, getFormat(format), arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        logger.trace(marker, getFormat(format), arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        logger.trace(marker, getFormat(format), argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        logger.trace(marker, getMsg(msg), t);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        logger.debug(getMsg(msg));
    }

    @Override
    public void debug(String format, Object arg) {
        logger.debug(getFormat(format), arg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        logger.debug(getFormat(format), arg1, arg2);
    }

    @Override
    public void debug(String format, Object... arguments) {
        logger.debug(getFormat(format), arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        logger.debug(getMsg(msg), t);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        logger.debug(marker, getMsg(msg));
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        logger.debug(marker, getFormat(format), arg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        logger.debug(marker, getFormat(format), arg1, arg2);
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        logger.debug(marker, getFormat(format), arguments);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        logger.debug(marker, getMsg(msg), t);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        logger.info(getMsg(msg));
    }

    @Override
    public void info(String format, Object arg) {
        logger.info(getFormat(format), arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        logger.info(getFormat(format), arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        logger.info(getFormat(format), arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        logger.info(getMsg(msg), t);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String msg) {
        logger.info(marker, getMsg(msg));
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        logger.info(marker, getFormat(format), arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        logger.info(marker, getFormat(format), arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        logger.info(marker, getFormat(format), arguments);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        logger.info(marker, getMsg(msg), t);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        logger.warn(getMsg(msg));
    }

    @Override
    public void warn(String format, Object arg) {
        logger.warn(getFormat(format), arg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        logger.warn(getFormat(format), arguments);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        logger.warn(getFormat(format), arg1, arg2);
    }

    @Override
    public void warn(String msg, Throwable t) {
        logger.warn(getMsg(msg), t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        logger.warn(marker, getMsg(msg));
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        logger.warn(marker, getFormat(format), arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        logger.warn(marker, getFormat(format), arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        logger.warn(marker, getFormat(format), arguments);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        logger.warn(marker, getMsg(msg), t);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(String msg) {
        logger.error(getMsg(msg));
    }

    @Override
    public void error(String format, Object arg) {
        logger.error(getFormat(format), arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        logger.error(getFormat(format), arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        logger.error(getFormat(format), arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        logger.error(getMsg(msg), t);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        logger.error(marker, getMsg(msg));
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        logger.error(marker, getFormat(format), arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        logger.error(marker, getFormat(format), arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        logger.error(marker, getFormat(format), arguments);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        logger.error(marker, getMsg(msg), t);
    }
}

package com.log.tracelog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TraceUtl {
    private static final ThreadLocal<TraceContext> traceContextLocal = new ThreadLocal<>();
    private static String pattern = "yyyyMMddHHmmssSSS";

    /**
     * 获取traceId
     *
     * @return
     */
    public static String getTraceId() {
        TraceContext traceContext = TraceUtl.traceContextLocal.get();
        if (traceContext != null && traceContext.getTraceId() != null) {
            return traceContext.getTraceId();
        }
        if (traceContext == null) {
            traceContext = new TraceContext();
            traceContextLocal.set(traceContext);
        }
        if (traceContext.getTraceId() == null || traceContext.getTraceId().isEmpty()) {
            traceContext.setTraceId(createTraceId());
        }
        return traceContext.getTraceId();
    }

    /**
     * 生成traceId
     *
     * @return
     */
    private static String createTraceId() {
        return new SimpleDateFormat(pattern).format(new Date()) + UUID.randomUUID().toString().replaceAll("\\-", "");
    }

    public static TraceContext getTraceContext() {
        getTraceId();
        return traceContextLocal.get();
    }

    public static void setTraceContext(TraceContext traceContext) {
        traceContextLocal.set(traceContext);
    }
}

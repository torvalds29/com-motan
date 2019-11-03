package com.log.tracelog;

public class TraceContext {
    /**
     * 链路请求id
     */
    private String traceId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}

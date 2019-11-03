/*
 * Copyright 2009-2016 Weibo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.motan;

import com.alibaba.fastjson.JSON;
import com.log.tracelog.LoggerFactory;
import com.log.tracelog.TraceContext;
import com.log.tracelog.TraceUtl;
import com.weibo.api.motan.core.extension.Activation;
import com.weibo.api.motan.core.extension.SpiMeta;
import com.weibo.api.motan.filter.Filter;
import com.weibo.api.motan.rpc.Caller;
import com.weibo.api.motan.rpc.Request;
import com.weibo.api.motan.rpc.Response;
import org.slf4j.Logger;

import java.util.Map;

/**
 * traceId 传递filter
 */
@SpiMeta(name = "traceIdFilter")
@Activation(sequence = 30)
public class TracingFilter implements Filter {
    private static final String TRACE_CONTEXT = "TRACE_CONTEXT";
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response filter(Caller<?> caller, Request request) {
        Map<String, String> attachments = request.getAttachments();
        if (attachments.get(TRACE_CONTEXT) != null) {
            TraceUtl.setTraceContext(JSON.parseObject(attachments.get(TRACE_CONTEXT), TraceContext.class));
            logger.info(" access request ");
        } else {
            logger.info(" send request ");
            attachments.put(TRACE_CONTEXT, JSON.toJSONString(TraceUtl.getTraceContext()));
        }
        return caller.call(request);
    }

}

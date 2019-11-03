package com.mq;


import com.alibaba.fastjson.JSON;
import com.log.tracelog.LoggerFactory;
import com.log.tracelog.TraceContext;
import com.log.tracelog.TraceUtl;
import org.slf4j.Logger;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class ActiveMqFastJsonMessageConverter implements MessageConverter {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final String TARGET_CLASS = "TARGET_CLASS";
    private final String TRACE_CONTEXT = "TRACE_CONTEXT";

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        TextMessage textMessage = session.createTextMessage(JSON.toJSONString(object));
        textMessage.setStringProperty(TARGET_CLASS, object.getClass().getName());
        textMessage.setStringProperty(TRACE_CONTEXT, JSON.toJSONString(TraceUtl.getTraceContext()));
        logger.info("convert message ok");
        return textMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {

        String traceContext = message.getStringProperty(TRACE_CONTEXT);
        if (traceContext != null && !traceContext.isEmpty()) {
            TraceUtl.setTraceContext(JSON.parseObject(traceContext, TraceContext.class));
        }
        logger.info("recive message ok");
        try {
            return JSON.parseObject(((TextMessage) message).getText(), Class.forName(message.getStringProperty(TARGET_CLASS)));
        } catch (ClassNotFoundException e) {
            logger.error("recive message error", e);
        }
        return null;
    }
}


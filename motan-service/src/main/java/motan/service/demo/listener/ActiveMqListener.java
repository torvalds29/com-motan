package motan.service.demo.listener;

import com.alibaba.fastjson.JSON;
import com.dto.DemoMessageDTO;
import com.log.tracelog.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqListener {
    Logger logger = LoggerFactory.getLogger(getClass());

    @JmsListener(destination = "testDestination",containerFactory = "queueContainer")
    public void listening(DemoMessageDTO demoMessageDTO) {
        logger.info("接收到消息 demoMessageDTO={} ", JSON.toJSONString(demoMessageDTO));
    }
}

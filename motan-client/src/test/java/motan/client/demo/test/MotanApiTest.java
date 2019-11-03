package motan.client.demo.test;

import com.MotanTestApi;
import com.alibaba.fastjson.JSON;
import com.dto.DemoMessageDTO;
import com.log.tracelog.LoggerFactory;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MotanApiTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @MotanReferer(group = "testgroup", directUrl = "127.0.0.1:8002")
    MotanTestApi motanTestApi;

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void testMotan() {
        String request = "hello motan";
        logger.info("发起请求 request={}", request);
        String response = motanTestApi.test(request);
        logger.info("请求结果response={}", response);
    }

    @Test
    public void testMessage() {
        DemoMessageDTO demoMessageDTO = new DemoMessageDTO(UUID.randomUUID().toString());
        logger.info("发送消息 message ={}", JSON.toJSONString(demoMessageDTO));
        jmsTemplate.convertAndSend("testDestination", demoMessageDTO);
    }

    @Test
    public void testTrace(){
        testMotan();
        testMessage();
    }
}

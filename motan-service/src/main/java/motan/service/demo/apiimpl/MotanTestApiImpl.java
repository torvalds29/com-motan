package motan.service.demo.apiimpl;

import com.MotanTestApi;
import com.log.tracelog.LoggerFactory;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.slf4j.Logger;

@MotanService
public class MotanTestApiImpl implements MotanTestApi {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String test(String arg) {
        logger.info("接收到请求={}", arg);
        String response = "this is a test response";
        logger.info("返回结果={}", response);
        return response;
    }
}

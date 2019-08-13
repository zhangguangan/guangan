package com.guangan.business.limit;

import com.guangan.business.CacheProxy;
import com.guangan.config.SpringContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RestrictionTokenGrant implements InitializingBean, Runnable {

    private static final Logger logger = Logger.getLogger(RestrictionTokenGrant.class);
    private static final String TOKEN_KEY = "TOKEN_KEY";


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("system limit init...");
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                logger.info("token grant is running...");
                Thread.sleep(10000);
            } catch (Exception e) {
                try {
                    Thread.sleep(10000);
                } catch (Exception e1) {

                }
                logger.error("发放令牌遇到异常，异常信息：", e);
            }
        }
    }
}

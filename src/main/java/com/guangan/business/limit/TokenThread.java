//package com.guangan.business.limit;
//
//import com.guangan.business.CacheProxy;
//import com.guangan.config.SpringContext;
//import org.apache.log4j.Logger;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//public class TokenThread implements Runnable {
//
//    @Resource
//    private CacheProxy cacheProxy;
//    private static final Logger logger = Logger.getLogger(TokenThread.class);
//    private static final String TOKEN_KEY = "TOKEN_KEY";
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                logger.info("token grant is running...");
//                if (cacheProxy == null) {
//                    cacheProxy = (CacheProxy) SpringContext.getBean("cacheProxy");
//                }
//
//                cacheProxy.put(TOKEN_KEY, 1, 1, TimeUnit.DAYS);
//                Thread.sleep(10000);
//            } catch (Exception e) {
//                try {
//                    Thread.sleep(10000);
//                } catch (Exception e1) {
//
//                }
//                logger.error("发放令牌遇到异常，异常信息：", e);
//            }
//        }
//    }
//}

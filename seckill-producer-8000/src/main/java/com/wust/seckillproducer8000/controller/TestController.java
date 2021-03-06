package com.wust.seckillproducer8000.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试web服务类
 *
 * @author wxl
 * @date 2020.3.5
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${server.port}")
    private String port;

    /**
     * 测试获取服务端口号
     * @return
     */
    @GetMapping("/getTestPort")
    public String getOrderPort() {
        log.info("当前请求端口:{}",port);
        return "currPort：" + port;
    }

}

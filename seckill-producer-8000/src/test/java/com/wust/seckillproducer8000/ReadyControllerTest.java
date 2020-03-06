package com.wust.seckillproducer8000;

import com.alibaba.fastjson.JSONObject;
import com.wust.seckillproducer8000.model.vo.in.ReadyVo;
import com.wust.seckillproducer8000.redis.config.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SeckillProducer8000Application.class})
@WebAppConfiguration
public class ReadyControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Autowired
    RedisService redisService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testReady() throws Exception{

        ReadyVo readyVo = new ReadyVo().setActivityId(1).setSpuId(2).setSkuId(3);
        String requestJson = JSONObject.toJSONString(readyVo);
        String url = "/ready/readyToSkill";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put(url)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println("=====================");
        System.out.println(mvcResult);

    }

    @Test
    public void testStock() throws Exception{

        String skuId = "3";
        String url = "/ready/stockNum/"+skuId;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println("=====================");
        System.out.println(mvcResult);

    }

}

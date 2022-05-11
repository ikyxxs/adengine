package com.ikyxxs.adengine;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.ikyxxs.adengine.controller.AdvertEngineController;
import com.ikyxxs.adengine.intercepter.RequestThreadLocalInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ApplicationTests {

    private MockMvc mvc;

    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new AdvertEngineController())
                .addInterceptors(new RequestThreadLocalInterceptor())
                .build();
        System.out.println("初始化mock模块");
    }

    @Test
    public void testAdvert() throws Exception {
        String deviceId = RandomUtil.randomString(8);
        String appId = "1";
        String url = StrUtil.format("/getAdvert?deviceId={}&appId={}", deviceId, appId);

        String resp = mvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println(resp);
    }
}

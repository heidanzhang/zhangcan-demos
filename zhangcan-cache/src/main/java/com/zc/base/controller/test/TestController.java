package com.zc.base.controller.test;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Auther: zhangcan
 * @Date: 2019/6/17 17:22
 * @Description:
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
    *@author zhangcan
    *@Description redis插入
    *@Date 17:30 2019/6/17
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/save")
    public String getTest(){
        HashMap hashMap = Maps.newHashMap();
        hashMap.put("zhangcan",12);
        stringRedisTemplate.opsForHash().put("spring-cache-zhangcan","zhangcan01",hashMap.toString());
        return "保存成功";
    }
}

package com.lhc.redislearn.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @GetMapping(value="/set")
    public String hello(){
        redisUtil.set("key1----","hello,i'm value1",60*60);
        redisUtil.set("key2----","hello,i'm value2",60*60);
        return "hello,world";
    }

    @GetMapping(value="/get")
    public String get(){
        String value1 = String.valueOf(redisUtil.get("key1----"));
        String value2 = String.valueOf(redisUtil.get("key2----"));
        return "key1----"+value1+" ; key2----"+value2;
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam String key){
        String value = String.valueOf(redisUtil.get(key));
        if(StringUtils.isEmpty(value)){
            return "no such key";
        }
        return key+"--->"+value;
    }

}

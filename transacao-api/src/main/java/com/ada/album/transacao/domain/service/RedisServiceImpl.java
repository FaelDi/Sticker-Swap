package com.ada.album.transacao.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
@Slf4j
public class RedisServiceImpl {

    private Jedis redis;

    public RedisServiceImpl() {
        this.redis = new Jedis("gusc1-sincere-wombat-30123.upstash.io", 30123, true);
        this.redis.auth("f218067ff1224a59af8627368afdf72d");
    }

    public void save(String key, String value) {
        if (redis.get(key) == null)
            redis.set(key, value);
        else {
            String strValorDaCarteira = redis.get(key);
            Double valorDaCarteiraReal = Double.valueOf(strValorDaCarteira);
            redis.set(key, valorDaCarteiraReal + value);
        }
    }

}

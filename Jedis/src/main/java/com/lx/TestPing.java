package com.lx;

import redis.clients.jedis.Jedis;

public class TestPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.93.49.84", 6379);
        jedis.auth("3333");
        System.out.println(jedis.ping());
    }
}

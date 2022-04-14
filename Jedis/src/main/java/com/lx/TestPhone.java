package com.lx;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class TestPhone {

    public static void main(String[] args) {
        String code = getCode();
        System.out.println(code);
        verifyCode("15602017102",code);
//        getRedisCode("15602017102","485109");
    }

    // 生成六位数验证码
    public static String getCode() {
        Random random = new Random();
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code.append(rand);
        }
        return code.toString();
    }

    // 每个手机每天只能发送三次，验证码放到redis中，设置过期时间
    public static void verifyCode(String phone, String code) {
        // 连接redis
        Jedis jedis = new Jedis("47.93.49.84", 6379);
        jedis.auth("3333");
        /**
         * 拼接key
         * 1.手机发送次数。
         * 2。验证码key。
         */
        String countKey = "VerifyCode" + phone + ":count";
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey,24*60*60,"1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("进入已超过最大次数");
            jedis.close();

            return;
        }

        String codeKey = "VerifyCode" + phone + ":code";
        jedis.setex(codeKey,120,code);
        jedis.close();
    }

    // 验证码校验
    public static void getRedisCode(String phone, String code) {
        // 连接redis
        Jedis jedis = new Jedis("47.93.49.84", 6379);
        jedis.auth("3333");
        String codeKey = "VerifyCode" + phone + ":code";
        String val = jedis.get(codeKey);
        if (val.equals(code)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
        jedis.close();
    }
}

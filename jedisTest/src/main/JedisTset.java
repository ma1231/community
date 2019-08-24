package main;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTset {
    public static void main(String[] args) {
        //JedisPoolConfig
        Jedis jedis=new Jedis("localhost",6379);
        int i=0;
        long start=System.currentTimeMillis();
        while(true){
            long end=System.currentTimeMillis();
            if(end-start>=1000){
                break;
            }
            i++;
            jedis.set("test"+i,"");
        }
        jedis.close();
        System.out.println(i);
    }
}

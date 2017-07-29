package com.frankstar.july.twentyfouth.algorithm;

import java.util.*;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/24
 * Project : java-improve
 */
public class LoadBalance {

    private Map<String, Integer> serverMap = new HashMap<String, Integer>() {
        {
            put("192.168.1.100", 1);
            put("192.168.1.101", 1);
            put("192.168.1.102", 4);
            put("192.168.1.103", 1);
            put("192.168.1.104", 1);
            put("192.168.1.105", 3);
            put("192.168.1.106", 1);
            put("192.168.1.107", 2);
            put("192.168.1.108", 1);
            put("192.168.1.109", 1);
            put("192.168.1.110", 1);

        }
    };

    public void random() {
        List<String> keyList = new ArrayList<>(serverMap.keySet());
        Random random = new Random();
        int idx = random.nextInt(keyList.size());
        String server = keyList.get(idx);
        System.out.println("random server: " + server);
    }

    public void weightRandom() {
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<>();
        for(Iterator<String> iterator = keySet.iterator(); iterator.hasNext();){
            String server = iterator.next();
            int weight = serverMap.get(server);
            for(int i = 0; i < weight; i++) {
                servers.add(server);
            }
        }
        String server = null;
        Random random = new Random();
        int idx = random.nextInt(servers.size());
        server = servers.get(idx);
        System.out.println(server);
    }
}

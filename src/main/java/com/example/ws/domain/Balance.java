package com.example.ws.domain;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Balance {

    private static List<Server> servers = Arrays.asList(new Server("192.168.0.1", 1), new Server("192.168.0.2", 1), new Server("192.168.0.3", 8));

    public static void main(String[] args) {
        Map<Server, Integer> map = new HashMap<>();
        servers.forEach(e -> map.put(e, 0));
        for (int i = 0; i < 100; i++) {
//            Server server = randomChoose(servers);
//            Server server = roundChoose(servers);
            Server server = weightChoose(servers);
            Integer integer = map.get(server);
            map.put(server, integer + 1);
        }
        System.out.println(map);

    }

    static int flag = 0;
    static Random r = new Random();

    private static Server roundChoose(List<Server> servers) {
        if (flag >= servers.size()) {
            flag = 0;
        }
        Server server = servers.get(flag);
        flag++;
        return server;
    }

    private static Server weightChoose(List<Server> servers) {
        int sum = servers.stream().mapToInt(Server::getWeight).sum();
        int random = r.nextInt(sum);
        Collections.sort(servers);
        int init = 0;
        for (Server server : servers) {
            init += server.getWeight();
            if (init >= random) {
                return server;
            }
        }
        return null;
    }

    static class Server implements Comparable<Server> {
        String ip;
        Integer weight;

        public Server(String ip, Integer weight) {
            this.ip = ip;
            this.weight = weight;
        }

        public Server() {
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "ip='" + ip + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(@NotNull Server o) {
            return this.weight.compareTo(o.weight);
        }
    }
}

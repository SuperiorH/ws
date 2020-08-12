package com.example.ws.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;

public class Bus {
    @SerializedName("name1")
    private String name;
    private Date startTime;

    public Bus(String name, Date startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public Bus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                '}';
    }

    public static void main(String[] args) {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().serializeNulls().create();
        Bus bus1 = new Bus("bus1", null);
        String s = gson.toJson(bus1);
        System.out.println(s);
        Bus bus = gson.fromJson(s, Bus.class);
        System.out.println(bus);
        String str = "{\"name1\":\"bus2\"}";
        Bus bus2 = gson.fromJson(str, Bus.class);
        System.out.println(bus2);
        String[] array = {"1", "2", "3"};
        String arrayStr = gson.toJson(array);
        System.out.println(arrayStr);
        String[] strings = gson.fromJson(arrayStr, String[].class);
        System.out.println(Arrays.toString(strings));
        System.out.println("666");
        String str1 = "{\"key\": \"value\"}";
        System.out.println(str1);
    }

}

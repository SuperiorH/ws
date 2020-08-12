package com.example.ws.test;

import java.util.HashSet;
import java.util.Objects;

public class Vertex {

    private String id;
    private String name;

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Vertex app1 = new Vertex("1", null);
        Vertex app2 = new Vertex("2", null);
        Vertex app3 = new Vertex("3", null);
        // 模拟我们从 json 载入这个图的过程
        // 这个时候 name 是不在图里面的
        HashSet<Vertex> sets = new HashSet<>();
        sets.add(app1);
        sets.add(app2);
        sets.add(app3);
        // 载入之后，我们会将属性设置好，欢迎应用名字的信息
        app1.name = "app1";
        app2.name = "app2";
        app3.name = "app3";

        // 返回 false
        System.out.println(sets.contains(app1));
        System.out.println(sets.stream().filter(x -> x.hashCode() == app1.hashCode()).findFirst());
        System.out.println(sets.stream().filter(x -> x.equals(app1)).findFirst());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id) &&
                Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

package com.example.ws.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test3 {

    /**
     * 输入：(6 -> 7 -> 1) + (4 -> 5 -> 6)
     * 输出：7 -> 0 -> 5
     * 原因：176 + 654 = 830
     * 348 + 465 = 813
     */
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(8);
        list1.add(4);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        LinkedList<Integer> list3 = new LinkedList<>();
        List<List<Object>> resultList = genNewList(list1, list2);
        System.out.println(resultList);
        for (int i = 0; i < resultList.size(); i++) {
            Integer value = (Integer) resultList.get(i).get(0);
            if (i == 0) {
                list3.add(value);
            } else {
                Boolean b = (Boolean) resultList.get(i - 1).get(1);
                list3.add(b ? value + 1 : value);
            }
        }
        System.out.println(list3);
    }

    static List<List<Object>> genNewList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        List<List<Object>> list = new ArrayList<>();
        for (int i = list1.size() - 1; i >= 0; i--) {
            Integer first1 = list1.getFirst();
            Integer first2 = list2.getFirst();
            list.add(add(first1, first2));
            list1.removeFirst();
            list2.removeFirst();
            if (list1.size() == 0) {
                break;
            }
        }
        return list;
    }

    static List<Object> add(int a, int b) {
        List<Object> list = new ArrayList<>(2);
        list.add(a + b >= 10 ? a + b - 10 : a + b);
        list.add(a + b >= 10);
        return list;
    }

}

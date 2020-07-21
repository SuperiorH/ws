package com.example.ws.test;


import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        method2();
    }

    private static void method2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Integer[] arr = {1, 2, 3};
        List<Integer> list2 = Arrays.asList(arr);
        System.out.println(list1);
        System.out.println(list2);
    }


    // array表示一个长度为n的数组
    // 代码中的array.length就等于n
    int[] array = new int[10];
    int count = 0;

    void insert(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }
        array[count] = val;
        ++count;
    }


}

package com.example.ws.test;

import org.springframework.util.StringUtils;

import java.util.*;

public class Test6 {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        Test6 t = new Test6();
        t.setStr("777");
        String aDefault = Optional.ofNullable(t.getStr()).filter(e -> !StringUtils.isEmpty(e)).orElse("default");
        System.out.println(aDefault);
    }

    private static int[] reverseArray(int[] arr) {
        if (Objects.isNull(arr)) {
            return new int[0];
        }
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
        return arr;
    }

    private static List<List<Integer>> cal(int[] arr, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = value - arr[i];
            if (map.containsKey(temp)) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(temp);
                tempList.add(arr[i]);
                list.add(tempList);
            } else {
                map.put(arr[i], i);
            }
        }
        return list;
    }


    /**
     * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
     * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
     * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set
     *
     * @param digits
     * @param n
     * @return
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        //确定n的位数
        int arrSize = digits.length;
        int length = Integer.valueOf(n).toString().length();
        int count = 0;
        for (int i = 1; i <= length; i++) {
            if (i < length) {
                double pow = Math.pow(arrSize, i);
            } else {

            }
        }
        return 1;
    }

    private static double test1(double target) {
        double floor = Math.floor(target);
        double centre = floor + 0.5;
        double ceil = Math.ceil(target);
        double from;
        double to;
        if (target <= centre) {
            from = floor;
            to = centre;
        } else {
            from = centre;
            to = ceil;
        }
        double value = target - from <= to - target ? from : to;
        return value <= 0 ? value + 0.01 : value - 0.01;
    }


}

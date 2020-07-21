package com.example.ws.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Test2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 7, 6, 1, 8};
//        int[] result = twoSum(array, 10);
//        System.out.println(Arrays.toString(result));
//        TreeMap<Integer, Integer> window = window(array, 3);
//        System.out.println(window);
//        System.out.println(window.lastEntry().getValue());
//        int maxNum = window2(array, 1);
//        System.out.println(maxNum);
        int seven = getMaxSubString2("abcdcefgacdb");
        System.out.println(seven);
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int i = binarySearch(arr, 7);
//        System.out.println(i);
    }

    //two sum问题
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (Objects.nonNull(map.get(j))) {
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    private static TreeMap<Integer, Integer> window(int[] array, int length) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length - length) {
                int temp = i;
                int sum = 0;
                while (temp - i < length) {
                    sum += array[temp];
                    temp++;
                }
                map.put(sum, i);
            }
        }
        return map;
    }

    private static int window2(int[] array, int length) {
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length - length) {
                int temp = i;
                int sum = 0;
                while (temp - i < length) {
                    sum += array[temp];
                    temp++;
                }
                value = Math.max(value, sum);
            }
        }
        return value;
    }


    //滑动窗口
    public static int maxNum(int[] array, int k) {
        if (array.length < k) {//如果k比数组长度还大，返回-1
            return -1;
        }
        int left = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += array[i];
        }
        int tempsum = sum;//tempsum记录每个窗口的总和
        while (left + k < array.length) {
            tempsum = tempsum - array[left] + array[left + k];
            left++;
            sum = Math.max(sum, tempsum);//sum取原sum和tempsum的较大值
        }
        return sum;
    }

    /**
     * 找出字符串中的最大字串
     */
    private static int getMaxSubString(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(chars[i]);
            if (sb.indexOf(temp) == -1) {
                sb.append(temp);
                if (i == chars.length - 1) {
                    strList.add(sb.toString());
                    break;
                }
            } else {
                strList.add(sb.toString());
                sb.deleteCharAt(0);
                i--;
            }
        }
        int maxLength = 0;
        for (String s1 : strList) {
            if (s1.length() > maxLength) {
                maxLength = s1.length();
            }
        }
        return maxLength;
    }

    private static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int getMaxSubString2(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(chars[i]);
            if (sb.indexOf(temp) == -1) {
                sb.append(temp);
                if (i == chars.length - 1) {
                    if (sb.length() > result.length()) {
                        result = sb.toString();
                    }
                    break;
                }
            } else {
                if (sb.length() > result.length()) {
                    result = sb.toString();
                }
                sb.deleteCharAt(0);
                i--;
            }
        }
        return result.length();
    }


}

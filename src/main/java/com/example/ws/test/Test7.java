package com.example.ws.test;

public class Test7 implements Cloneable {

    private static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length;
        int startIndex = 0, endIndex = length - 1;
        while (startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (target > arr[middle]) startIndex++;
            if (target < arr[middle]) endIndex--;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int startIndex, int endIndex) {
        if (arr == null || arr.length == 0 || startIndex >= endIndex) {
            return -1;
        }
        int middle = (startIndex + endIndex) / 2;
        if (target == arr[middle]) return middle;
        if (target > arr[middle]) {
            return binarySearch(arr, target, ++startIndex, endIndex);
        } else {
            return binarySearch(arr, target, startIndex, --endIndex);
        }
    }

}

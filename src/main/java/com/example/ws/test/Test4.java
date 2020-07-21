package com.example.ws.test;

public class Test4 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcbb"));

    }

    /**
     * 字符串最长回文子串   abccde  cc
     */
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (isHuiWen(sb.toString())) {
                if (sb.length() > result.length()) {
                    result = sb.toString();
                }
                sb.append(chars[i]);
                if (i == chars.length - 1) {
                    if (isHuiWen(sb.toString()) && sb.length() > result.length()) {
                        result = sb.toString();
                    }
                    break;
                }
            } else {
                sb.deleteCharAt(0);
                i--;
            }

        }
        return result;
    }


    public static boolean isHuiWen(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }


}

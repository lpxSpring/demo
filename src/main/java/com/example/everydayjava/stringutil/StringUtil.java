package com.example.everydayjava.stringutil;

public class StringUtil {
    private StringUtil(){};

    public static boolean isEqual(String str1, String str2){
        if (null == str1 && null == str2){
            return true;
        }
        if (null == str1 || null == str2){
            return false;
        }

        if (str1.length() != str2.length()){
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]){
                return false;
            }
        }

        return true;
    }

    public static int strCompareTo(String str1, String str2){
        if (null == str1 || null == str2){
            throw new NullPointerException();
        }

        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 == length2){
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            int n = 0;
            while (n < length1){
                if (chars1[n] != chars2[n]){
                    return chars1[n] - chars2[n];
                }

                n++;
            }

            return 0;
        }

        return length1 - length2;
    }

    public static void main(String[] args) {
        /*System.out.println(isEqual("lpx", "lpx"));
        System.out.println(isEqual("lpx", "lpx1"));
        System.out.println(isEqual("lpx1", "lpx"));
        System.out.println(isEqual("", ""));
        System.out.println(isEqual(null, ""));
        System.out.println(isEqual("", null));
        System.out.println(isEqual(null, null));*/


        System.out.println(strCompareTo("11212", "1"));
        System.out.println("11212".compareTo("1"));
    }
}

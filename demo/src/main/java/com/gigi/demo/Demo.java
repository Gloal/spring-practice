package com.gigi.demo;

public class Demo {

    public static int grandParentMethod(int position) {
        return parentMethod(position);
    }

    private static int parentMethod(int position) {
        return getNumber(position);
    }

    public static int getNumber(int position) {
        int output = 0;

            int[] numbers = new int[] { 1, 2, 3, 4, 5 };
            output = numbers[position];

        return output;
    }
}

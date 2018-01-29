package pers.caijx.leetcode;

import java.util.Arrays;

/**
 题目要求：一个非负整数被表示为一个数组，数组中每一个元素代表该整数的一个位。
 数组的下标越小，代表的位数越高。现在对该数组做加一运算，请返回结果数组。
 Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 * Created by Administrator on 2018/1/29/029.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9,9,9,9})));
    }
}

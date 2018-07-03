package pers.caijx.leetcode;

import java.util.stream.IntStream;

/**
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 Credits:
 Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 * Created by Administrator on 2018/7/3/003.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int[] listOfNumbers = {a, b};
        return IntStream.of(listOfNumbers).sum();
    }
}

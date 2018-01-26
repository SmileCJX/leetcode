package pers.caijx.leetcode;

/**
 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * Created by Administrator on 2018/1/26/026.
 */
public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        //use ‘log3(n) = log(n)/lob(3)’ to calculate the max number for a safer solution.
        int maxPow = (int)(Math.pow(3,(int)(Math.log(Integer.MAX_VALUE)/Math.log(3))));
        return (n > 0 && maxPow % n == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(54));
    }
}

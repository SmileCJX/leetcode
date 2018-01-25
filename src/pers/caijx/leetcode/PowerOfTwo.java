package pers.caijx.leetcode;

/**
 Given an integer, write a function to determine if it is a power of two.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Created by Administrator on 2018/1/25/025.
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(18));
    }
}

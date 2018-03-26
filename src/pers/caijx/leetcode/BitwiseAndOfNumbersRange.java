package pers.caijx.leetcode;

/**
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.
 * Created by Administrator on 2018/3/26/026.
 */
public class BitwiseAndOfNumbersRange {

    /**
     1、last bit of (odd number & even number) is 0.
     2、when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
     3、Move m and n rigth a position.
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(4,6));
    }
}

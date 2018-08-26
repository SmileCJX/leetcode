package pers.caijx.leetcode;

/**
 Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

 If there aren't two consecutive 1's, return 0.



 Example 1:

 Input: 22
 Output: 2
 Explanation:
 22 in binary is 0b10110.
 In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 The first consecutive pair of 1's have distance 2.
 The second consecutive pair of 1's have distance 1.
 The answer is the largest of these two distances, which is 2.
 Example 2:

 Input: 5
 Output: 2
 Explanation:
 5 in binary is 0b101.
 Example 3:

 Input: 6
 Output: 1
 Explanation:
 6 in binary is 0b110.
 Example 4:

 Input: 8
 Output: 0
 Explanation:
 8 in binary is 0b1000.
 There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.


 Note:

 1 <= N <= 10^9

 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。

 如果没有两个连续的 1，返回 0 。
 * Created by caijx on 2018/8/26/026.
 */
public class BinaryGap {

    /**
     *  It allows me to evaluate bit by bit Integer N.
     The 'N >>> i' will get the ith bit into the least significant bit position.
     Then shifting to the left 31 bits (<< 31) , gets the least significant bit into the most significant bit position.
     Finally right unsigned shifting 31 bits to the right (>>> 31) will get the most significant bit, into the less significant bit and fill the other bits with 0's

     At the end of the sequence the variable 't' is always gonna be either 1 or 0, depending on what value was the ith bit in the integer.

     Imagine a 4 bit integer: N = 0b1001

     N >>> 0 => 1001 << 3 => 1000 >>> 3 => 0001 = 1
     N >>> 1 => 0100 << 3 => 0000 >>> 3 => 0000 = 0
     N >>> 2 => 0010 << 3 => 0000 >>> 3 => 0000 = 0
     N >>> 3 => 0001 << 3 => 1000 >>> 3 => 0001 = 1

     If you observe the final result of each line we obtain the integer values representing each bit.

     Note: The correct order of the bits in this case should be take from the last iteration to the first iteration, because the number is symmetrical in bits, it doesn't matter, but if the order of the bits was important you could just iterate from i = 31 to i = 0, instead of from 0 to 31.
     * @param N
     * @return
     */
    public int binaryGap(int N) {
        int max = 0;
        int dist = 0;
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            int t = N >>> i << 31 >>> 31;
            if (t == 1) {
                flag = true;
                max = dist > max ? dist : max;
                dist = 1;
            } else if (flag) {
                dist++;
            }
        }
        return max;
    }
}

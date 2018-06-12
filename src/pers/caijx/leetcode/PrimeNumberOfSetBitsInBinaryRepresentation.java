package pers.caijx.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

 (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

 Example 1:

 Input: L = 6, R = 10
 Output: 4
 Explanation:
 6 -> 110 (2 set bits, 2 is prime)
 7 -> 111 (3 set bits, 3 is prime)
 9 -> 1001 (2 set bits , 2 is prime)
 10->1010 (2 set bits , 2 is prime)
 Example 2:

 Input: L = 10, R = 15
 Output: 5
 Explanation:
 10 -> 1010 (2 set bits, 2 is prime)
 11 -> 1011 (3 set bits, 3 is prime)
 12 -> 1100 (2 set bits, 2 is prime)
 13 -> 1101 (3 set bits, 3 is prime)
 14 -> 1110 (3 set bits, 3 is prime)
 15 -> 1111 (4 set bits, 4 is not prime)
 Note:

 L, R will be integers L <= R in the range [1, 10^6].
 R - L will be at most 10000.

 问题描述：给一个数字区间范围，判断这个区间的数字的二进制形式中，1的个数为质数的数字共计多少个。

 * Created by Administrator on 2018/6/12/012.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (primes.contains(countOnes(i))) {
                count++;
            }
        }
        return count;
    }

    private Integer countOnes(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation instance = new PrimeNumberOfSetBitsInBinaryRepresentation();
//        System.out.println(instance.countPrimeSetBits(289051,294301));
        System.out.println(instance.countPrimeSetBits(248657,257888));
    }
}

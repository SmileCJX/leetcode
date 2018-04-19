package pers.caijx.leetcode;

/**
 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.
 Example 1:
 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 Example 2:
 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * Created by Administrator on 2018/4/19/019.
 */
public class NumberComplement {

    /**
     for example:
     100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num, then do substraction
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }

    public static void main(String[] args) {
        NumberComplement instance = new NumberComplement();
        System.out.println(instance.findComplement(5));
    }
}

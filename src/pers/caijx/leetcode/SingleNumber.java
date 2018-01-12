package pers.caijx.leetcode;

/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 因为A XOR A = 0，且XOR运算是可交换的，于是，对于实例{2,1,4,5,2,4,1}就会有这样的结果：

 (2^1^4^5^2^4^1) => ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
 就把只出现了一次的元素(其余元素均出现两次)给找出来了！

 算法复杂度为O(n)，且不需要额外空间
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Created by Administrator on 2018/1/12/012.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,1,4,5,2,4,1}));
    }
}

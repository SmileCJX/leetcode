package pers.caijx.leetcode;

import java.util.Arrays;

/**
 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 * Created by Administrator on 2018/4/28/028.
 */
public class MaximumProductOfThreeNumbers {

    /**
     先排序，然后再做处理。因为元素值可能为负值，所以不能简单地从数组末尾开始，往前取三个数。因为数组末尾的元素值组大，
     三个数必包含它，然后就剩两个数。当数组头部分元素为负值，则这两个数有可能在头，如果数组为正值，则这两个数在末尾部分。
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1],nums[nums.length - 2] * nums[nums.length - 3]) * nums[nums.length - 1];
    }
}

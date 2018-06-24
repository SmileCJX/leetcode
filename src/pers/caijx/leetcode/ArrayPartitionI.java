package pers.caijx.leetcode;

import java.util.Arrays;

/**
 Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
 (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 Note:
 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].

 这道题目给了我们一个数组有2n integers， 需要我们把这个数组分成n对，然后从每一对里面拿小的那个数字，
 把所有的加起来，返回这个sum。并且要使这个sum 尽量最大。如何让sum 最大化呢，我们想一下，如果是两个数字，一个很小，
 一个很大，这样的话，取一个小的数字，就浪费了那个大的数字。所以我们要使每一对的两个数字尽可能接近。
 我们先把nums sort 一下，让它从小到大排列，接着每次把index： 0， 2， 4...偶数位的数字加起来就可以了。

 * Created by Administrator on 2018/6/24/024.
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}

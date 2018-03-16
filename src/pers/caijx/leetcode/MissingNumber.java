package pers.caijx.leetcode;

/**
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1

 Input: [3,0,1]
 Output: 2
 Example 2

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 * Created by Administrator on 2018/3/16/016.
 */
public class MissingNumber {

    /**
     we can just add all the numbers from [0, n] together and minus the sum of the n-1 numbers in array.

     Just like this.
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }
}

package pers.caijx.leetcode;

/**
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * Created by Administrator on 2018/2/9/009.
 */
public class TwoSumTwoInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) {
            return indice;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            long v = numbers[left] + numbers[right];  //in case of the integer overflow.
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }

    public static void main(String[] args) {
        TwoSumTwoInputArrayIsSorted twoSumTwoInputArrayIsSorted = new TwoSumTwoInputArrayIsSorted();
        int[] nums = twoSumTwoInputArrayIsSorted.twoSum(new int[]{2,7,11,15},9);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
package pers.caijx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 *You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *Example:
 *Given nums = [2, 7, 11, 15], target = 9,
 *
 *Because nums[0] + nums[1] = 2 + 7 = 9,
 *return [0, 1].
 * Created by Administrator on 2017/12/19/019.
 */
public class TwoSum {

    /**
     * 方法1 ： 暴力破解
     * 遍历数组的每一个元素，并去寻找另外一个匹配的数值相加等于目标值
     * 时间复杂度：0(n2)
     * 空间复杂度：0(n2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Two-pass Hash Table
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int compareNum = target - nums[i];
            if (map.containsKey(compareNum) && map.get(compareNum) != i) {
                return new int[]{i,map.get(compareNum)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * One-pass Hash Table
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int compareNum = target - nums[i];
            if(map.containsKey(compareNum)) {
                return new int[]{i,map.get(compareNum)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void  main(String[] args) {
        int [] nums = {2,11,11,7};
        int target = 9;
        int [] result = twoSum3(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

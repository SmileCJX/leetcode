package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 * Created by Administrator on 2018/4/2/002.
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray instance = new FindAllNumbersDisappearedInAnArray();
        List<Integer> list = instance.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}

package pers.caijx.leetcode;

/**
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 三次反转数组：第一次反转整个数组；第二次反转数组的前K个数；第三次反转数组剩下的数

 例如：

 一维数组[1,2,3,4,5,6,7],k=3

 第一次反转：7,6,5,4,3,2,1

 第二次反转：5,6,7,4,3,2,1

 第三次反转：5,6,7,1,2,3,4    最终结果
 * Created by Administrator on 2018/2/8/008.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int[] nums,int start,int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}

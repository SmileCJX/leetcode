package pers.caijx.leetcode;

/**
 * 混合插入有序数组
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 * Created by Administrator on 2018/1/8/008.
 */
public class MergeSortedArray {

    /**
     * 这是一道数组操作的题目，思路比较明确，就是维护三个index，分别对应数组A，数组B，和结果数组。然后A和B同时从后往前扫，
     * 每次迭代中A和B指向的元素大的便加入结果数组中，然后index-1，另一个不动。
     * 这里从后往前扫是因为这个题目中结果仍然放在A中，如果从前扫会有覆盖掉未检查的元素的可能性。
     * 算法的时间复杂度是O(m+n),m和n分别是两个数组的长度，空间复杂度是O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
    }
}

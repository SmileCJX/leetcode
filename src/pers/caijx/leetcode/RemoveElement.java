package pers.caijx.leetcode;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {

    /**
     * Two Pointers
     * Time complexity : O(n)O(n). Assume the array has a total of nn elements, both ii and jj traverse at most 2n2n steps.
       Space complexity : O(1)O(1).
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Two Pointers - when elements to remove are rare
     * Time complexity : O(n)O(n). Both ii and nn traverse at most nn steps.
     * In this approach, the number of assignment operation is equal to the number of elements to remove.
     * So it is more efficient if elements to remove are rare.
       Space complexity : O(1)O(1).
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(removeElement2(new int[]{3,2,4,3},3));
    }
}

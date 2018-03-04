package pers.caijx.leetcode;

import java.util.Arrays;

/**
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.
 * Created by Administrator on 2018/3/4/004.
 */
public class ContainsDuplicate {

    /**
     Approach #1 (Naive Linear Search) [Time Limit Exceeded]
     Intuition

     For an array of nn integers, there are C(n,2) = \frac{n(n+1)}{2}C(n,2)=
     ​2
     ​
     ​n(n+1)
     ​​  pairs of integers. Thus, we may check all \frac{n(n+1)}{2}
     ​2
     ​
     ​n(n+1)
     ​​  pairs and see if there is any pair with duplicates.

     Algorithm

     To apply this idea, we employ the linear search algorithm which is the simplest search algorithm. Linear search is a method of finding if a particular value is in a list by checking each of its elements, one at a time and in sequence until the desired one is found.

     For our problem, we loop through all nn integers. For the iith integer nums[i], we search in the previous i-1 integers for the duplicate of nums[i]. If we find one, we return true; if not, we continue. Return false at the end of the program.

     To prove the correctness of the algorithm, we define the loop invariant. A loop invariant is a property that holds before (and after) each iteration. Knowing its invariant(s) is essential for understanding the effect of a loop. Here is the loop invariant:

     Before the next search, there are no duplicate integers in the searched integers.

     The loop invariant holds true before the loop because there is no searched integer. Each time through the loop we look for any any possible duplicate of the current element. If we found a duplicate, the function exits by returning true; If not, the invariant still holds true.

     Therefore, if the loop finishes, the invariant tells us that there is no duplicate in all nn integers.

     Complexity Analysis

     Time complexity : O(n^2)O(n2). In the worst case, there are \frac{n(n+1)}{2}2
     ​
     ​n(n+1)
     ​​  pairs of integers to check. Therefore, the time complexity is O(n^2)O(n​2).

     Space complexity : O(1)O(1). We only used constant extra space.
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < i; ++j) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     Intuition

     If there are any duplicate integers, they will be consecutive after sorting.

     Algorithm

     This approach employs sorting algorithm. Since comparison sorting algorithm like heapsort is known to provide O(n \log n)O(nlogn) worst-case performance,
     sorting is often a good preprocessing step. After sorting, we can sweep the sorted array to find if there are any two consecutive duplicate elements.
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

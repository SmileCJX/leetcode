package pers.caijx.leetcode;

import java.util.HashSet;

/**
 A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S,
 where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

 Suppose the first element in S starts with the selection of element A[i] of index = i,
 the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

 Example 1:
 Input: A = [5,4,0,3,1,6,2]
 Output: 4
 Explanation:
 A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

 One of the longest S[K]:
 S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 Note:
 N is an integer within the range [1, 20,000].
 The elements of A are all distinct.
 Each element of A is an integer within the range [0, N-1].

 * Created by caijx on 2018/7/16/016.
 */;
public class ArrayNesting {

    HashSet<Integer> set = new HashSet<>();

    /**
     * 从多个起点到达同一个值之后的路径都是完全相同的，所以每个值最多遍历一次，时间复杂度O(N)，每次遍历到就加到set中
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,check(nums,i));
        }
        return max;
    }

    private int check(int[] nums, int k) {
        int res = 0;
        while (!set.contains(k)) {
            set.add(k);
            k = nums[k];
            res++;
        }
        return res;
    }
}

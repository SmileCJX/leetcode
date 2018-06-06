package pers.caijx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 In a string S of lowercase letters, these letters form consecutive groups of the same character.

 For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

 Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

 The final answer should be in lexicographic order.



 Example 1:

 Input: "abbxxxxzzy"
 Output: [[3,6]]
 Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 Example 2:

 Input: "abc"
 Output: []
 Explanation: We have "a","b" and "c" but no large group.
 Example 3:

 Input: "abcdddeeeeaabbbcd"
 Output: [[3,5],[6,9],[12,14]]


 Note:  1 <= S.length <= 1000
 * Created by Administrator on 2018/6/6/006.
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new LinkedList<>();
        if (S == null || S.length() < 3) {
            return result;
        }
        int start = 0;
        int end = 1;
        for (; end < S.length(); end++) {
            if (S.charAt(start) != S.charAt(end)) {
                if (end - start >= 3) {
                    result.add(Arrays.asList(new Integer[]{start,end - 1}));
                }
                start = end;
            }
        }
        if (end - start >= 3) {
            result.add(Arrays.asList(new Integer[]{start,end - 1}));
        }
        return result;
    }

    public static void main(String[] args) {
        PositionsOfLargeGroups instance = new PositionsOfLargeGroups();
        System.out.println(instance.largeGroupPositions("bbbaaaaa"));
    }
}

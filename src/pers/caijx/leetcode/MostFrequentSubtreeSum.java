package pers.caijx.leetcode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 Given the root of a tree, you are asked to find the most frequent subtree sum.
 The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * Created by caijx on 2018/8/24/024.
 */
public class MostFrequentSubtreeSum {

    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        post(root,map);
        List<Integer> ls = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                ls.add(key);
            }
        }
        int[] nums = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            nums[i] = ls.get(i);
        }
        return nums;
    }

    private int post(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftSum = post(node.left,map);
        int rightSum = post(node.right,map);
        int sum = leftSum + rightSum + node.val;
        int count = map.getOrDefault(sum,0) + 1;
        map.put(sum,count);
        max = Math.max(max,count);
        return sum;
    }
}

package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
     3
   / \
  9  20
    /  \
   15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.
 * Created by Administrator on 2018/6/28/028.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<>();
        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<>();
        // using dfs to sum all value in same level and count number of node in same level
        dfs(0,root,answer,counter);
        // answer will be answer[level] / counter[level]
        for (int level = 0;level < answer.size(); level++ ) {
            answer.set(level,answer.get(level) / counter.get(level));
        }
        return answer;
    }

    private void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }
        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }
        answer.set(level,answer.get(level) + node.val);
        counter.set(level,counter.get(level) + 1);
        // go left node and right node
        dfs(level + 1,node.left,answer,counter);
        dfs(level + 1,node.right,answer,counter);
    }
}

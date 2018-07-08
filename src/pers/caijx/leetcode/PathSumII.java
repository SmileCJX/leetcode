package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 * Created by caijx on 2018/7/8/008.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        pathSumHelper(root,sum,current,result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        current.add(new Integer(root.val));
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(current));
            current.remove(current.size() - 1);
            return;
        } else {
            pathSumHelper(root.left,sum - root.val,current,result);
            pathSumHelper(root.right,sum - root.val,current,result);
        }
        current.remove(current.size() - 1);
    }
}

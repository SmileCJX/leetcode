package pers.caijx.leetcode;

/**
 Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

 Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

 If no such second minimum value exists, output -1 instead.

 Example 1:
 Input:
 2
 / \
 2   5
 / \
 5   7

 Output: 5
 Explanation: The smallest value is 2, the second smallest value is 5.
 Example 2:
 Input:
 2
 / \
 2   2

 Output: -1
 Explanation: The smallest value is 2, but there isn't any second smallest value.
 * Created by Administrator on 2018/5/1/001.
 */
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return -1;
        }
        int left = root.left.val > root.val ? root.left.val : findSecondMinimumValue(root.left);
        int right = root.right.val > root.val ? root.right.val : findSecondMinimumValue(root.right);
        if (left >= 0 && right >= 0) {
            return Math.min(left,right);
        } else {
            return Math.max(left,right);
        }
    }
}

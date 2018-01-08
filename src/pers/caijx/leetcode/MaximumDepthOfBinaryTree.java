package pers.caijx.leetcode;

/**
 二叉树最大深度
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 * Created by Administrator on 2018/1/8/008.
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public static void main(String[] args) {

    }
}

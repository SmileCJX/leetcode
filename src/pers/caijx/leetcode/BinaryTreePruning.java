package pers.caijx.leetcode;

/**
 We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

 Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

 (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

 Example 1:
 Input: [1,null,0,0,1]
 Output: [1,null,0,null,1]

 Explanation:
 Only the red nodes satisfy the property "every subtree not containing a 1".
 The diagram on the right represents the answer.


 Example 2:
 Input: [1,0,1,0,0,0,1]
 Output: [1,null,1,null,1]



 Example 3:
 Input: [1,1,0,1,1,0,1,0]
 Output: [1,1,0,1,1,null,1]



 Note:

 The binary tree will have at most 100 nodes.
 The value of each node will only be 0 or 1.
 问题描述:
 给定二叉树的头节点root，这个二叉树的每个节点值为0或者1.
 现在要对该二叉树剪枝，对节点剪枝的条件为该节点的所有子树都为0

 问题分析:
 后续遍历即可。
 * Created by Administrator on 2018/6/15/015.
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left != null && left.left == null && left.right == null && left.val == 0) {
            root.left = null;
        }
        if (right != null && right.left == null && right.right == null && right.val == 0) {
            root.right = null;
        }
        return root;
    }
}

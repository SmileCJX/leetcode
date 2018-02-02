package pers.caijx.leetcode;

/**
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Created by Administrator on 2018/2/2/002.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(2));
        node.left.setLeft(new TreeNode(3));
        node.left.setRight(new TreeNode(3));
        node.left.left.setLeft(new TreeNode(4));
        node.left.left.setRight(new TreeNode(4));

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        System.out.println(minimumDepthOfBinaryTree.minDepth(node));
    }
}

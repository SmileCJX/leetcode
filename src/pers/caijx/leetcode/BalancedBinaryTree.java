package pers.caijx.leetcode;

/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:

 3
 / \
 9  20
 /  \
 15   7
 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 Return false.
 * Created by Administrator on 2018/1/31/031.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lH = height(node.left);
        if (lH == -1) {
            return -1;
        }
        int rH = height(node.right);
        if (rH == -1) {
            return -1;
        }
        if (lH - rH < -1 || lH - rH > 1) {
            return -1;
        }
        return Math.max(lH,rH) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(2));
        node.left.setLeft(new TreeNode(3));
//        node.left.setRight(new TreeNode(3));
        node.left.left.setLeft(new TreeNode(4));
        node.left.left.setRight(new TreeNode(4));

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(node));
    }
}

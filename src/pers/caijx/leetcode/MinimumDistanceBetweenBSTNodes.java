package pers.caijx.leetcode;

/**
 Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

 Example :

 Input: root = [4,2,6,1,3,null,null]
 Output: 1
 Explanation:
 Note that root is a TreeNode object, not an array.

 The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

 4
 /   \
 2      6
 / \
 1   3

 while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 Note:

 The size of the BST will be between 2 and 100.
 The BST is always valid, each node's value is an integer, and each node's value is different.
 求BST的两个节点之间的最小差值。
 * Created by Administrator on 2018/5/15/015.
 */
public class MinimumDistanceBetweenBSTNodes {

    private Integer prev;

    private int minDist;

    /**
     ST想中序遍历是有序的,所以先进性中序遍历，得到有序列表，然后找出相邻的两个节点差值的最小值即可。
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        prev = null;
        minDist = Integer.MAX_VALUE;
        inorder(root);
        return minDist;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDist = Math.min(minDist,root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}

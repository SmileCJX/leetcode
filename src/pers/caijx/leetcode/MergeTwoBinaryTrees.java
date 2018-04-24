package pers.caijx.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:
 Input:
 Tree 1                     Tree 2
       1                          2
     / \                        / \
    3   2                      1   3
  /                            \   \
 5                              4   7
 Output:
 Merged tree:
       3
     / \
    4   5
   / \   \
  5   4   7
 Note: The merging process must start from the root nodes of both trees.
 规则是，都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * Created by Administrator on 2018/4/24/024.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeTrees(t1 == null ? null : t1.left,t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right,t2 == null ? null : t2.right);

        return newNode;
    }
}

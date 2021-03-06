package pers.caijx.leetcode;

/**
 Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

 Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 For example,

 Given the tree:
      4
    / \
   2   7
  / \
 1   3
 And the value to insert: 5
 You can return this binary search tree:

       4
     /   \
    2     7
   / \   /
  1  3  5
 This tree is also valid:

         5
      /   \
     2     7
   / \
 1   3
 \
  4
 * Created by caijx on 2018/11/4/004.
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left,val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}

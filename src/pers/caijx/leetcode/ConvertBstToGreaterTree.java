package pers.caijx.leetcode;

/**
 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
    5
  /   \
 2     13

 Output: The root of a Greater Tree like this:
     18
   /   \
 20     13
 把每个结点值加上所有比它大的结点值总和当作新的结点值。
 * Created by Administrator on 2018/3/21/021.
 */
public class ConvertBstToGreaterTree {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}

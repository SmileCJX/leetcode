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

    /**
     Idea: Reversely traverse the tree and keep a sum of all previously visited values.
     Because its a BST, values seen before are all greater than current node.val.
     That’s what we want according to the problem.
     将中序遍历左根右的顺序逆过来，变成右根左的顺序，这样就可以反向计算累加和sum，同时更新结点值
     * @param root
     * @return
     */
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

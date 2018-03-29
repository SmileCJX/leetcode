package pers.caijx.leetcode;

/**
 Invert a binary tree.

      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 to

      4
    /   \
   7     2
 / \   / \
 9   6 3   1
 * Created by Administrator on 2018/3/29/029.
 */
public class InvertBinaryTree {

    /**
     Lets start with straightforward - recursive DFS - it’s easy to write and pretty much concise.
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static void main(String[] args) {

    }
}

package com.mengnan.simple;

/**
 * date: 2022-03-22
 * link: https://leetcode-cn.com/problems/balanced-binary-tree/
 * result: https://leetcode-cn.com/problems/balanced-binary-tree/submissions/
 */
public class PingHengErChaShuByLeetcodeSolution {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // 判断树的左右节点相差是否超过1，并且左右节点都是平衡树
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(
                    root.right);
        }
    }

    /**
     * 求树的高度
     *
     * @param root
     * @return
     */
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}

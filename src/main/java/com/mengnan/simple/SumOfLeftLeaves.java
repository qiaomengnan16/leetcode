package com.mengnan.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * date: 2022-03-10
 * link: https://leetcode-cn.com/problems/sum-of-left-leaves/
 * result: https://leetcode-cn.com/problems/sum-of-left-leaves/submissions/
 */
public class SumOfLeftLeaves {

    public class TreeNode {
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

    /**
     * 这题主要注意是左叶子节点，叶子节点，而不是左节点
     * 判断出所有的左叶子节点返回相+即可
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            res += isLeafNode(root.left) ? root.left.val : sumOfLeftLeaves(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

    /**
     * 通过Queue做
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves2(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            if (pollNode.left != null) {
                if (isLeafNode(pollNode.left)) {
                    res += pollNode.left.val;
                } else {
                    queue.add(pollNode.left);
                }
            }
            if (pollNode.right != null && !isLeafNode(pollNode.right)) {
                queue.add(pollNode.right);
            }
        }
        return res;
    }


    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

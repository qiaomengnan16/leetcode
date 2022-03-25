package com.mengnan.simple;

import java.util.LinkedList;
import java.util.Queue;


/**
 * date: 2022-03-25
 * link: https://leetcode-cn.com/problems/symmetric-tree/
 * result: https://leetcode-cn.com/problems/symmetric-tree/submissions/
 */
public class SymmetricTree {

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

    /**
     * 答此题先要明白什么是对称二叉树，即树的左边等于右边，右边等于左边
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        // 根节点为空直接返回false
        if (root == null) {
            return false;
        }
        // 比对左右节点
        return check(root.left, root.right);
    }

    /**
     * 递归方式处理
     * @param left
     * @param right
     * @return
     */
    public static boolean check(TreeNode left, TreeNode right) {
        // 左右对比都是空，可认为是相同
        if (left == null && right == null) {
            return true;
        }
        // 一空一不空  不相同
        if (left == null || right == null) {
            return false;
        }
        // 判断二者val是否相同，继续递归判断二者的左子树与右子树，右子树与左子树比对
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }

    /**
     * 队列方式处理
     * @param left
     * @param right
     * @return
     */
    public static boolean check2(TreeNode left, TreeNode right) {
        // 往队列中添加左右二者
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(left);
        queue.add(right);
        // 不为空就继续循环
        while (!queue.isEmpty()) {
            // 弹出两个
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            // 都为空相等 继续循环
            if (p == null && q == null) {
                continue;
            }
            // 一空一不空 或者 二者val不同 直接返回false
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            // 添加左与右
            queue.offer(p.left);
            queue.offer(q.right);
            // 添加右与左
            queue.offer(p.right);
            queue.offer(q.left);
            // 继续下一轮循环
        }
        return true;
    }

}

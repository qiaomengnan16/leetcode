package com.mengnan.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * date: 2022-04-15
 * link: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * result: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 */
public class MinimumDepthOfBinaryTree {

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

    // 深度
    public static int minDepth(TreeNode root) {
        int min = 0;
        if (root != null) {
            min = 1;
            int leftMin = minDepth(root.left);
            int rightMin = minDepth(root.right);
            if (root.left != null && root.right != null) {
                min += Math.min(leftMin, rightMin);
            } else if (root.left != null) {
                min += leftMin;
            } else {
                min += rightMin;
            }
        }
        return min;
    }

    // 深度
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int childMin = Integer.MAX_VALUE;
        if (root.left != null) {
            childMin = Math.min(minDepth2(root.left), childMin);
        }
        if (root.right != null) {
            childMin = Math.min(minDepth2(root.right), childMin);
        }
        return childMin + 1;
    }


    static class Node {
        TreeNode node;
        int depth;

        Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // 广度
    public static int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.node.left == null && currentNode.node.right == null) {
                return currentNode.depth;
            }
            if (currentNode.node.left != null) {
                queue.add(new Node(currentNode.node.left, currentNode.depth + 1));
            }
            if (currentNode.node.right != null) {
                queue.add(new Node(currentNode.node.right, currentNode.depth + 1));
            }
        }
        return 0;
    }

}

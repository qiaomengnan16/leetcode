package com.mengnan.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * date: 2022-03-30
 * link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * result: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 */
public class BinaryTreeInorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorderTraversalD(root, res);
//        return res;
//    }
//
//
//    public static void inorderTraversalD(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            inorderTraversalD(root.left, res);
//            res.add(root.val);
//            inorderTraversalD(root.right, res);
//        }
//    }

}

package com.mengnan.simple;

/**
 * date: 2022-4-2
 * link: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * result: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
 */
public class JiangYouXuShuZuZhuanHuanWeiErChaSouS33 {

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


    public static TreeNode sortedArrayToBST(int[] nums) {
        // 数组有序，说明是中序遍历
        // 使用二分法，找到中间的那个作为根，然后左右元素分别递归作为左右子树即可
        return sortedArrayToBST2(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST2(int[] nums, int start, int end) {
        // 如果start > end 说明递归完毕
        if (start > end) {
            return null;
        }
        // 找出中间的root
        int mid = (start + end) / 2;
        // 左边的元素继续递归作为左子树
        TreeNode left = sortedArrayToBST2(nums, start, mid - 1);
        // 右边的元素继续递归作为右子树
        TreeNode right = sortedArrayToBST2(nums, mid + 1, end);
        // 返回root树
        return new TreeNode(nums[mid], left, right);
    }

}
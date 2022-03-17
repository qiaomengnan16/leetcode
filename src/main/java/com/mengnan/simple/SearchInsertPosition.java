package com.mengnan.simple;

/**
 * date: 2022-3-17
 * link: https://leetcode-cn.com/problems/search-insert-position/
 * result: https://leetcode-cn.com/problems/search-insert-position/submissions/
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        // 初始化左指针右指针，以及默认插入位置是最后一个+1(即length)
        int left = 0, right = nums.length - 1, ans = nums.length;
        // 两个交叉说明查找完毕
        while (left <= right) {
            // 取中间值
            int mid = ((right - left) >> 1) + left;
            // 如果小于等于中间值, 说明 ans 应该是偏左的
            if (target <= nums[mid]) {
                // 暂时先将 ans 设置为左边最后个位置
                ans = mid;
                // 说明在左边, 收缩查找范围
                right = mid - 1;
            } else {
                // 说明在右边，向右收缩查找范围
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{2,3,5}, 4));
    }

}

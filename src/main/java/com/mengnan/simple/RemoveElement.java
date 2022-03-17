package com.mengnan.simple;

/**
 * date: 2022-3-13
 * link: https://leetcode-cn.com/problems/remove-element/
 * result: https://leetcode-cn.com/problems/remove-element/submissions/
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 快慢指针
        // 快慢指针二者都初始化在0
        // slow用于保存和val相等的下标位置
        // 当fast位置的元素不等于val，就向前移动的slow的位置，然后slow向前进1
        // 如果fast的位置等于val，则slow不再前进，等待下一个非val值放入，再前进
        int fast = 0, slow = 0, n = nums.length;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}

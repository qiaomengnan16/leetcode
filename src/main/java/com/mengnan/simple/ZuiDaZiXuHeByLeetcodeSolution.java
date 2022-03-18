package com.mengnan.simple;

/**
 * date: 2022-3-18
 * link: https://leetcode-cn.com/problems/maximum-subarray/
 * result: https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class ZuiDaZiXuHeByLeetcodeSolution {


    public static int maxSubArray(int[] nums) {
        // pre: 单独一段f(i)的最大值
        // max: 所有段f(i)中的最大值
        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}

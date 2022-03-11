package com.mengnan.simple;

/**
 * date: 2022-03-10
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * result: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
public class ShanChuPaiXuShuZuZhongDeZhongFuTudo {

    public static int removeDuplicates(int[] nums) {
        if (nums == null)  {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        // 快慢指针
        // 快指针在前面扫, 慢指针表示非重复元素可挪动的位置
        // 快慢指针初始化时都在下标1的位置
        // fast发现当前元素和前面的元素是不同元素时，slow就要往后挪
        // 例如二者开始都是下标1，fast如果发现 下标1和下标0不是一样的，那么下标1肯定不能被覆盖
        //     * slow就需要向前走一位, fast也要继续扫描下一个,以此循环 直到fast扫描结束
        // 最终的slow就是不重复的元素的个数
        int fast = 1, slow = 1, n = nums.length;
        while(fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 3}));
    }


}

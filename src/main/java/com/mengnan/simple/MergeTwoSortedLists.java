package com.mengnan.simple;

/**
 * date: 2022-03-10
 * link: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * result: https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 如果1为空  就返回2
        if (list1 == null) {
            return list2;
        }
        // 2为空 就返回1
        if (list2 == null) {
            return list1;
        }
        // 最开始的比较大小决定了最终返回的是1还是2，如果1第一个元素比2小，那么最终返回的就是1这个链表，否则就是2
        // 后续的都是为了比对衔接
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {


    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String res = this.val + ",";
            while (this.next == null) {
                res += this.val + ",";
            }
            return res;
        }
    }

}

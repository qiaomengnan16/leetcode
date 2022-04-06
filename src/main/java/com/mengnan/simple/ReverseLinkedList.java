package com.mengnan.simple;
/**
 * date: 2022-4-6
 * link: https://leetcode-cn.com/problems/reverse-linked-list/
 * result: https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 */
public class ReverseLinkedList {

    public static class ListNode {
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
    }

    public static ListNode reverseList3(ListNode head) {
        // 慢指针
        ListNode prev = null;
        // 快指针
        ListNode curr = head;
        // 快指针不为空时继续
        while (curr != null) {
            // 记录下一个节点
            ListNode currNext = curr.next;
            // 将当前节点翻转，next指向慢指针的节点
            curr.next = prev;
            // 将慢指针进1
            prev = curr;
            // 快指针进1
            curr = currNext;
        }
        // 快指针为空后，返回慢指针指向的最后一个节点
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        // 如果head为Null直接返回
        // 如果head.next为null，说明已经到了翻转链表的最后一个节点，以此节点作为新的头节点返回
        if (head == null || head.next == null) {
            return head;
        }
        // 找到头节点
        ListNode newHeader = reverseList2(head.next);
        // 将原本正序的下一节点的下一节点设置为自己，以此翻转
        head.next.next = head;
        // 将自己的next设置为null，防止原本的头节点形成环
        head.next = null;
        // 返回新的头结点
        return newHeader;
    }

    public static ListNode reverseList(ListNode head) {
        // 前一个节点
        ListNode prev = null;
        // 当前节点
        ListNode curr = head;
        // 循环条件是当前节点不为空
        while (curr != null) {
            // 记录正序的下一个节点
            ListNode nextCurr = curr.next;
            // 改变当前节点的下一个节点为上一节点，即反序
            curr.next = prev;
            // 记录截止当前节点的反序
            prev = curr;
            // 将当前节点设置为正序的下一节点
            curr = nextCurr;
        }
        // 返回最终的反序列表
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.println(reverseList3(head).val);
    }

}

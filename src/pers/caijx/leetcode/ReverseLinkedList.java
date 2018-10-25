package pers.caijx.leetcode;

import java.util.List;

/**
 * Created by caijx on 2018/10/25/025.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
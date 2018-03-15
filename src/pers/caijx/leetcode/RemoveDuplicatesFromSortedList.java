package pers.caijx.leetcode;

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 * Created by Administrator on 2018/3/15/015.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.next != null && head.val == head.next.val ? head.next : head;
    }
}

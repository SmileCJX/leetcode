package pers.caijx.leetcode;

/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 * Created by Administrator on 2018/1/13/013.
 */
public class LinkedListCycle {

    /**
     Use two pointers, walker and runner.
     walker moves step by step. runner moves two steps at time.
     if the Linked List has a cycle walker and runner will meet at some
     point.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

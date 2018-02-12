package pers.caijx.leetcode;

/**
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 * Created by Administrator on 2018/2/12/012.
 */
public class RemoveLinkedListElements {

    /**
     * 通过递归调用到链表末尾，然后回来，需要要删的元素，将链表next指针指向下一个元素即可
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

    }
}

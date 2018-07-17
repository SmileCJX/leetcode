package pers.caijx.leetcode;

/**
 Design your implementation of the circular double-ended queue (deque).

 Your implementation should support following operations:

 MyCircularDeque(k): Constructor, set the size of the deque to be k.
 insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 isEmpty(): Checks whether Deque is empty or not.
 isFull(): Checks whether Deque is full or not.


 Example:

 MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 circularDeque.insertLast(1);			// return true
 circularDeque.insertLast(2);			// return true
 circularDeque.insertFront(3);			// return true
 circularDeque.insertFront(4);			// return false, the queue is full
 circularDeque.getRear();  			// return 32
 circularDeque.isFull();				// return true
 circularDeque.deleteLast();			// return true
 circularDeque.insertFront(4);			// return true
 circularDeque.getFront();			// return 4


 Note:

 All values will be in the range of [0, 1000].
 The number of operations will be in the range of [1, 1000].
 Please do not use the built-in Deque library.

 * Created by caijx on 2018/7/17/017.
 */
public class DesignCircularDeque {

    int[] arr;

    int f = 0;
    int e = 0;
    int k;
    int num = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        arr = new int[k];
        this.k = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            f = f == 0 ? k - 1 : f - 1;
        }
        arr[f] = value;
        num++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            e = (e + 1) % k;
        }
        arr[e] = value;
        num++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (f != e) {
            f = (f + 1) % k;
        }
        num--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (f != e) {
            e = e == 0 ? k - 1 : e - 1;
        }
        num--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[f];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[e];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return num == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return num == k;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
package pers.caijx.leetcode;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 常规的方法是：用一个变量存放当前最小值，但是会出现这种情况，就是当我的stack pop掉的值刚好是最小值时候，后面就没法知道当前的最小值了。

 怎么办呢？可以考虑在push阶段做个改变，就是在我每次往stack里面push数据的时候，跟当前的最小值比较，如果比当前最小值还小的话，
 那么将当前最小值入栈，再把最小值修改为这个值。在pop阶段，如果遇到pop出来的值刚好等于当前的最小值，
 那么将下一个值pop出来，并将pop出来的值设置为当前栈中最小值，这个值就是在push阶段时放进去的，表明这个位置的下面位置都比这个值小。
 * Created by Administrator on 2018/3/13/013.
 */
public class MinStack {

    int min = Integer.MAX_VALUE;

    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min  = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

package day0314_jianzhi09;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer>stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        //stack1.push(value);
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        int head = cQueue.deleteHead();
        System.out.println(head+"");
    }
}

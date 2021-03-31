package day0314_jianzhi59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Deque<Integer> deque;
    Queue<Integer> queue;
    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        //一层一层的把原双端队列中小于新value的值全部出队
        while(!deque.isEmpty()&&deque.peekLast()<value){
            deque.pollLast();
        }
        //此时deque中仅剩比value大的在队头
        //入队
        deque.offerLast(value);
        queue.offer(value);

    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int pollNum=queue.poll();
        //如果出队的是当前最大值，则双队列的最大值也相应出队
        if(pollNum==deque.peekFirst()){
            deque.pollFirst();
        }
        return pollNum;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
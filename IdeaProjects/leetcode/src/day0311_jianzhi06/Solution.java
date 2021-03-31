package day0311_jianzhi06;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(head==null) {return null;}
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        //System.out.println(list.size()+"list大小");
        int[] ints = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ints[i] = list.get(ints.length-1-i);
        }
        return ints;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        Solution solution = new Solution();
        int[] ints = solution.reversePrint(listNode);
        for (int anInt : ints) {
            System.out.print(anInt);
        }

    }
}

package leetcode_go;

import CommonClassUtils.ListNode;

public class ReverseLinkedList {
//翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode oldPre = null;
        ListNode cur = head;
        ListNode oldNext = null;
        while(cur!=null){
            oldNext = cur.next;
            cur.next = oldPre;
            oldPre = cur;

            cur = oldNext;

        }
        return oldPre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next  = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next= new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode1 = reverseLinkedList.reverseList(listNode);
        ListNode res = listNode1;
        while(res!=null){
            System.out.print(res.getVal());
            res = res.next;
        }
    }
}

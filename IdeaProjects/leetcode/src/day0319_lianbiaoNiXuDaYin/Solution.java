package day0319_lianbiaoNiXuDaYin;



import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.add(listNode.val);
            ret.addAll(printListFromTailToHead(listNode.next));

        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ArrayList<Integer> integers = solution.printListFromTailToHead(head);
        for (Integer integer : integers) {
            System.out.print(integer);
        }

    }

}

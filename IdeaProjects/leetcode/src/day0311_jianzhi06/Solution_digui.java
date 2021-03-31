package day0311_jianzhi06;

public class Solution_digui {
    int count=0;
    int[] nums;
    public int[] reversePrint(ListNode head) {

        recur(head);
        int[] nums = new int[count];
        for(int i=0;i<count;i++){
            nums[count-1-i] =head.val;
            head = head.next;
        }
        return nums;
    }
    void recur(ListNode head){
        if(head!=null) {
            count++;
            recur(head.next);
        }
        }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        Solution_digui solution_digui = new Solution_digui();
        int[] print = solution_digui.reversePrint(listNode);
        for (int i : print) {
            System.out.print(i+"");
        }
    }
    }






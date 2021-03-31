package day0316_lk209;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0) return 0;
        Deque<Integer> deque = new LinkedList<>();
        int left=0,right=0;
        int sum=0;
        int subLength=nums.length+1;

        while(right<nums.length){
            deque.addLast(nums[right]);//入队
            sum+=nums[right];
            System.out.println("第一位置的l"+left+"---r"+right+"此时的sum"+sum);

            //当目前的和已经大于了目标数，尝试缩小子数组范围，
            while(sum>=target&&(sum-nums[left]>=target)){

                deque.pollFirst();
                sum = sum - nums[left];
                System.out.println("第二位置的l"+left+"---r"+right+"此时的sum"+sum);

                left++;
                subLength=deque.size()<subLength?deque.size():subLength;
                System.out.println("此时sublength"+subLength);

            }
            right++;

        }

        for (Integer integer : deque) {
            System.out.println(integer+"");
        }
        return subLength!=nums.length+1?subLength:0;
    }

    public static void main(String[] args) {
        int[] aaa = {5,1,3,5,10,7,4,9,2,8};
        Solution solution = new Solution();
        int i = solution.minSubArrayLen(15, aaa);
        System.out.println(i+"");
    }
}

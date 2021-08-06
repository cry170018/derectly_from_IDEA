package ZiDianXu;

import java.util.Arrays;

public class ZiDianXu {
    //字节0720面试类型,likou 31
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for( int i=len-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                Arrays.sort(nums,i,len);

                for(int j=i;j<len;j++){
                    if(nums[j]>nums[i-1]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,6,5,4,3,2,1};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}

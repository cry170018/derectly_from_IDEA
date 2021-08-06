package Find;

public class ErFenChaZhao {
/*
* int[] arr = new int[10];
* 此时：l取0，h取10
* */
    int  erFenChaZhao(int[] nums,int l,int h,int target){

        while(l<h){
            int mid  = (l+h)/2;
            if(nums[mid]>target){
                h = mid;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                return mid-1;
            }
        }


        return -1;
    }
}

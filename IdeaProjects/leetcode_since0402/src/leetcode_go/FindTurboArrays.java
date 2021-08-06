package leetcode_go;

public class FindTurboArrays {


        public boolean search(int[] nums, int target) {
            if(nums.length==0||target<nums[0]&&target>nums[nums.length-1]){
                return false;
            }
            int left = 0;
            int right = nums.length-1;
            while(left<=right){

                if(target>nums[left])  left++;

                if(target<nums[right]) right--;

                if(target==nums[left]||target==nums[right]) return true;


            }
            return false;

        }

    public static void main(String[] args) {
        FindTurboArrays findTurboArrays = new FindTurboArrays();
        int [] arr = {2,5,6,0,0,1,2,3};
        boolean search = findTurboArrays.search(arr,3);
        System.out.println(search);
    }

}

package tenSort;

public class QuikSortAdvantage {
//https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
        public String minNumber(int[] nums) {
            int len = nums.length;
            String[] strs = new String[len];
            int i=0;
            for(int num:nums){
                strs[i++] = String.valueOf(num);
            }
            quickSort(strs,0,len-1);
            StringBuilder sb = new StringBuilder();
            for(String str:strs){
                sb.append(str);
            }

            return sb.toString();

        }

        void quickSort(String[] strs,int lo,int hi){

            if(lo<hi){
                int pivotIndex = partition(strs,lo,hi);
                quickSort(strs,lo,pivotIndex-1);
                quickSort(strs,pivotIndex+1,hi);
            }
        }

        int partition(String[] strs,int lo,int hi){
            String pivot = strs[lo];
            while(lo<hi){
                //注意这里的比较大小，是字符串拼接比大小：a+b<b+a ==>表示a<b，即a应该在前面
                while(lo<hi&&(strs[hi]+pivot).compareTo(pivot+strs[hi])>=0)hi--;
                strs[lo] = strs[hi];
                while(lo<hi&&(strs[lo]+pivot).compareTo(pivot+strs[lo])<=0)lo++;
                strs[hi] = strs[lo];

            }

            strs[lo] = pivot;
            return lo;


    }
}

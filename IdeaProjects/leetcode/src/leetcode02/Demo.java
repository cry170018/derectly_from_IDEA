package leetcode02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*题目要求，区分三色
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* https://leetcode-cn.com/problems/sort-colors/
* */
public class Demo {
    public static void main(String[] args) {
        int[] ints = {2,0,2,1,1,0};
        sortColors(ints);
    }

    public static void sortColors(int[] nums) {
/*        int index=0,cnt0=0,cnt1=0,cnt2=0;
        for(index=0;index<nums.length;index++){
            if(nums[index]==0) cnt0++;
            if(nums[index]==1) cnt1++;
            if(nums[index]==2) cnt2++;
        }
        ArrayList<Integer> arr = new ArrayList<>();

        for(index=0;index<cnt0;index++){
            arr.add(0);
        }
        for(index=0;index<cnt1;index++){
            arr.add(1);
        }
        for(index=0;index<cnt2;index++){
            arr.add(2);
        }
        nums=arr.*/
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            arrayList.add(nums[index]);
        }
Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
};
        arrayList.sort(comparator);
        System.out.println(arrayList);
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(arrayList);
    }
}

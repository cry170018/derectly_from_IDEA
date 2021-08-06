package tenSort;

public class QuikSort {

     public void quikSort(int[] arr,int lo,int hi){


        if(lo<hi){
            int index =  partition(arr,lo,hi);

            quikSort(arr,lo,index-1);
            quikSort(arr,index+1,hi);
        }

    }
    //升序分割一次
    int partition(int[] arr,int lo,int hi){
        int pivot = arr[lo];//把轴备份出来
        //从右往左找到第一个小于pivot的值，从左往右找到第一个大于pivot的值，交换他俩位置，重复直到lohi重合，此时的位置就是pivot在最终排列中应该在的位置
        while(lo<hi){

            while(lo<hi&&arr[hi]>=pivot) hi--;
            arr[lo]=arr[hi];

            while(lo<hi&&arr[lo]<=pivot) lo++;
            arr[hi]=arr[lo];
        }
        //该位置就是pivot在最终排列中应该在的位置，赋值
        arr[lo] = pivot;
        return lo;
    }
}

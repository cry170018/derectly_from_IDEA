package tenSort;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Arrays;

public class MergeSort   {

    public void sort(int[] arr) {
        //temp为了防止频繁创建额外数组，恋上数据结构做到了只需要一半大小的temp数组
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        //System.out.println(Arrays.toString(arr));
    }
    private void mergeSort(int[] arr,int begin, int end,int[] temp){
        if(end>begin){
            int mid = (end+begin)>>1;
            mergeSort(arr,begin,mid,temp);
            mergeSort(arr,mid+1,end,temp);

            merge(arr,begin,mid,end,temp);
        }

    }
/*
* 将begin-mid和mid-end合并
* */
    private void merge(int[] array,int begin,int mid,int end,int[] temp){
        //int[] temp = Arrays.copyOf(array,end-begin+1);
        int i = begin;
        int j = mid+1;
        int k = 0;//临时数组的index
        while (i <= mid && j <= end) {
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while(i <= mid) {// 如果左边剩余，元素填充进temp中
            temp[k++] = array[i++];
        }
        while(j <= end) {// 如果右序列剩余，元素填充进temp中
            temp[k++] = array[j++];
        }
        k=0;
        while(begin <= end) {
            array[begin++] = temp[k++];
        }
        //array = Arrays.copyOf(temp,temp.length);
        System.out.println(Arrays.toString(array));
    }


}

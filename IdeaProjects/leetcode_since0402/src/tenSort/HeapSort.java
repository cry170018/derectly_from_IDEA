package tenSort;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {

    public void heapSort(int[] arr){
        int index = arr.length;
        Queue<Integer>heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i : arr) {
            heap.offer(i);
        }
      //  System.out.println(Arrays.toString(heap.toArray()));

        //把堆顶拿出来，作为结果集从后往前放;拿走后，堆内会自动重建堆，即siftdown，把新的堆顶放到首位
        while(heap.size()>0){
            arr[--index]  = heap.poll();
        }
//        System.out.println(Arrays.toString(heap.toArray()));
//        System.out.println(Arrays.toString(arr));
//        for (Integer integer : heap) {
//            System.out.print(integer+" ");
//        }


    }
}

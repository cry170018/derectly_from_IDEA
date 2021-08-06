package tenSort;

public class BubbleSort {

    public void sort(int[] arr){
        for (int end = arr.length-1; end >0 ; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if(arr[begin]<arr[begin-1]){
                    int temp = arr[begin];
                    arr[begin]  = arr[begin-1];
                    arr[begin-1] = temp;
                }

            }
        }
       // return arr;

    }
}

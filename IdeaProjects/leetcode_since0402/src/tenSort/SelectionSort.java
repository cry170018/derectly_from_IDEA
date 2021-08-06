package tenSort;

public class SelectionSort {
    public void selectionSort(int[] arr){
        for(int end =arr.length-1; end>=0;end--){
            int maxIndex = 0;
            for(int i =1;i<=end;i++ ){
                if(arr[maxIndex]<=arr[i]){
                    maxIndex = i;

                }
            }
            int temp = arr[end];
            arr[end] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

    }
}

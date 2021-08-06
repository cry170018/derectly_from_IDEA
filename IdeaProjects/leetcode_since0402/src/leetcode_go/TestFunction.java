package leetcode_go;

import jdk.nashorn.internal.runtime.ListAdapter;
import tenSort.*;

import javax.swing.tree.TreeNode;
import java.io.CharArrayReader;
import java.util.*;

public class TestFunction {


    public static void main(String[] args) {
    boolean [] booleans = new boolean[10];
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }

/*
  //测试几个sort
  int[] arr = new int[]{4,3,2,1,2,3,4,3};
        //System.out.println(Arrays.toString(arr));

        long start = System.currentTimeMillis();
        //new HeapSort().heapSort(arr);
//        new InsertSort().insertSort(arr);
        //new BubbleSort().sort(arr);
       // new MergeSort().sort(arr);

       // new QuikSort().quikSort(arr,0,arr.length-1);
        new ShellSort().sort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        System.out.println(Arrays.toString(arr));*/
//        int[][] matrix = new int[3][5];
//        Arrays.fill(matrix[0], 1);
//        for (int i = 0; i < matrix.length; i++) {
//            matrix[i][0]=1;
//        }
//
//        for(int row = 1;row<3;row++){
//            for(int col=1;col<5;col++){
//                matrix[row][col] = matrix[row][col-1]+matrix[row-1][col];
//            }
//        }
//        for (int i = 0; i < matrix.length&&i!=1; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//
//        }
//        System.out.println("---");
//        int i=0;
//        while (i<matrix.length&&i!=1){
//            System.out.println(Arrays.toString(matrix[i]));
//
//            i++;
//        }

    }


}

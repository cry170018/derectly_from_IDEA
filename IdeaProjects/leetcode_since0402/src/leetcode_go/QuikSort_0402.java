package leetcode_go;

import java.util.Arrays;
//topK
//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488820&idx=1&sn=e6a58b67b0050ae8144bb8ea579cf0d0&scene=21#wechat_redirect
   class QuikSort_0402 {
        private int[] getLeastNumbers(int[] arr, int k) {
            if(arr.length==0||arr.length==1){
                return arr;
            }
            int lo=0;
            int hi = arr.length-1;

             quikSort(arr,lo,hi,k);
            System.out.println(Arrays.toString(arr));
            return Arrays.copyOf(arr,k);
        }

     private    void quikSort(int[] arr,int lo,int hi,int k){


            if(lo<hi){
                int index =  partition(arr,lo,hi,k);

                quikSort(arr,lo,index-1,k);
                quikSort(arr,index+1,hi,k);
            }

        }
        //升序分割一次
        private int partition(int[] arr,int lo,int hi,int k){
            int pivot = arr[lo];//把轴备份出来

            for(;lo<hi;){
                while(lo<hi&&arr[hi]>=pivot) hi--;
                arr[lo]=arr[hi];
                while(lo<hi&&arr[lo]<=pivot) lo++;
                arr[hi]=arr[lo];
            }

            arr[lo] = pivot;
            return lo;
        }

    public static void main(String[] args) {
        QuikSort_0402 quikSort_0402 = new QuikSort_0402();

        int []arr = {0,0,1,2,4,2,2,3,1,4};

        int[] leastNumbers = quikSort_0402.getLeastNumbers(arr, 8);
        System.out.println(Arrays.toString(leastNumbers));
    }
    }

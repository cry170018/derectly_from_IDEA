package tenSort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort  {

    public void sort(int[] arr){
        //步长的集合
        List<Integer> stepSequence = shellStepSequence(arr);

        for (Integer step : stepSequence) {
            sort(step,arr);
        }
    }
/*
* 对当前步长下的所有列进行插入排序，
* step之后的每一个元素，都要与所在列的数进行插入排序
* */
    private void sort(int step,int[] arr) {
        for(int j = step;j<arr.length;j++){
            int temp = arr[j];
            int k;
            for(k = j-step;k>=0;k-=step){
                if(temp<arr[k]){
                    arr[k+step] = arr[k];
                }else{
                    break;
                }
            }
            arr[k+step] = temp;
        }
    }
/*
* 生成希尔本人创建的步长序列
* */
public List<Integer> shellStepSequence(int[] array){
        List<Integer>stepSequence = new ArrayList<>();
        int step = array.length;
        while((step = step>>1)>0){
            stepSequence.add(step);
        }
        return  stepSequence;
    }


}

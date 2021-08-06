package tenSort;

public class InsertSort extends Sort {
    public void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];//temp，因为后移操作会将此数覆盖，所以先拿出来
            int j = i - 1;
            //把i-1到0的所有大于这个value的往后挪一位
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    //不大于value的，在往前也都不大于value，所以退出循环，
                    // value就应该放在这个值得后面，j+1
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }


    //恋上数据结构的写法，他是每次都比较大小，交换，
    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            int cur = i;
            //value比i的值小则换位
            while (cur > 0 && com(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}

package tenSort;

public abstract class Sort {
    protected int[] array;
    private int comCount;
    private int swapCount;
    public void sort(int[] array){
        if(array.length<2||array==null) return;
        this.array = array;
        sort();
    }

    protected abstract void sort();

    protected int com(int i1,int i2){
        comCount++;
        return array[i1]-array[i2];

    }

    protected void swap(int i1,int i2){
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
        swapCount++;
    }
}

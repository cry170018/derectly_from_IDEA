package suibianGao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Solution {
    volatile static  boolean run = true;
    public static void main(String[] args) throws InterruptedException {
    Thread t1  = new Thread(()->{
        while(run){

        }
    });
    t1.start();
    Thread.sleep(1000);
    run = false;
        System.out.println(111);
    }
}

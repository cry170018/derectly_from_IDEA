package leetcode_go;

import com.sun.javafx.image.IntPixelGetter;

import java.lang.reflect.Array;
import java.util.*;

public class HeightSort_tanxin {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o2[0]-o1[0];
        }
        );
        for (int i = 0; i < people.length; i++) {
            int position = people[i][1];
            res.add(position,people[i]);
        }
        Iterator<int[]> iterator = res.iterator();
        int i=0;
        while(iterator.hasNext()){

            people[i++]= iterator.next();
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        HeightSort_tanxin heightSort_tanxin = new HeightSort_tanxin();
        int[][] ints = heightSort_tanxin.reconstructQueue(people);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

package Tu.LinJieBiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LinJieBiao {

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<HashMap<Integer,Integer>> table = new ArrayList<>();

        for(int i=0;i<n;i++){
            table.add(new HashMap<>());
        }
        for(int[] arr:times){
            HashMap<Integer,Integer>cur = table.get(arr[0]);
            cur.put(arr[1],arr[2]);
        }





        return -1;
    }
}

package HashOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class LRU_byMyself_0722 {
//在力扣会超时
    int cap;
    LinkedList<HashMap<Integer, Integer>> capacity = new LinkedList<>();

    public LRU_byMyself_0722(int cap) {
        this.cap = cap;
    }

    public int get(int key) {
        for (int i = 0; i < capacity.size(); i++) {
            HashMap<Integer, Integer> thisMap = capacity.get(i);
            if (thisMap.containsKey(key)) {
                capacity.remove(i);
                capacity.addLast(new HashMap(){{
                    put(key,thisMap.get(key));
                }});
                System.out.println("get "+"key="+key+"value="+thisMap.get(key));
                capacity.addLast(capacity.remove(i));

                return thisMap.get(key);
            }
        }
        System.out.println("get "+"key="+key+"value="+ "-1");

        return -1;
    }

    public void put(int key, int value) {
        System.out.println("put "+"key="+key+"value="+value);
        for (int i = 0; i < capacity.size(); i++) {
            if (capacity.get(i).containsKey(key)) {
                capacity.get(i).put(key, value);
                return;
            }
        }

        capacity.addLast(new HashMap() {{
            put(key, value);
        }});
        while (capacity.size() > cap) {
            capacity.removeFirst();
        }

    }

    public void show() {
        for (int i = 0; i < capacity.size(); i++) {
            for (Integer integer : capacity.get(i).keySet()) {
                System.out.print("当前有key"+integer);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRU_byMyself_0722 lru = new LRU_byMyself_0722(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);

        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);






    }
}

package leetcode_go;

import java.util.LinkedHashMap;

public class LRU_0408 {

        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();


        public LRU_0408(int capacity) {
            this.cap = capacity;
        }



        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            System.out.println("用户进行了访问操作，key："+key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            System.out.println("加入新的key："+key);
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            Integer remove = cache.remove(key);
            cache.put(key, val);
        }

        public void show(LRU_0408 lru_0408){
            System.out.println("容器中现有key:");
            for (Integer integer : lru_0408.cache.keySet()) {
                System.out.print(integer);
            }
            System.out.println();
        }

    public static void main(String[] args) {
        LRU_0408  lru_0408 = new LRU_0408(3);
        lru_0408.put(1,1);
        lru_0408.put(2,2);
        lru_0408.put(3,3);
        lru_0408.put(4,4);

        lru_0408.show(lru_0408);

        lru_0408.get(2);
        lru_0408.show(lru_0408);

        lru_0408.put(5,5);

        lru_0408.show(lru_0408);

    }

}

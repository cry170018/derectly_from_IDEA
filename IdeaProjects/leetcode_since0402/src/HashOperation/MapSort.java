package HashOperation;

import java.util.*;

public class MapSort {
    //根据map的值排序

        public String frequencySort(String s) {
            char[] arrays = s.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            ////////////////////////////////////////////
            for(char cha:arrays){
                map.put(cha,map.getOrDefault(cha, 0)+1);
            }
            List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
            Collections.sort(list,(a, b)->{
                if (b.getValue() != a.getValue()) return b.getValue() - a.getValue();
                return a.getKey() - b.getKey();
            });
            /////////////////////////////////////////////////
            Iterator<Map.Entry<Character, Integer>> iterator = list.iterator();
            while(iterator.hasNext()){
                Map.Entry<Character, Integer> next = iterator.next();
                while(next.getValue()>0){
                    sb.append(next.getKey());
                    next.setValue(next.getValue()-1);
                }
            }

            return sb.toString();
        }

}

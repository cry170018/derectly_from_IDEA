package day0315_jianzhi50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public char firstUniqChar(String s) {
        if(s.equals(" ")) return  ' ';
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) map.replace(s.charAt(i),0);
            else map.put(s.charAt(i),1);
        }

        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i))==1){
                return  s.charAt(i);
            }
        }
           return ' ';
    }
}

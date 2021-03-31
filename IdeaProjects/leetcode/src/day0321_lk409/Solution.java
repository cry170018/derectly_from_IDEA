package day0321_lk409;

import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        boolean hasSingleFlag = false;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt))
                map.put(charAt, map.get(charAt) + 1);
            else {
                map.put(charAt, 1);
            }
        }
        for (Character ch : map.keySet()) {
            res += map.get(ch) / 2 * 2;
            if (map.get(ch) % 2 == 1 && res % 2 == 0) hasSingleFlag = true;
        }
        return res = hasSingleFlag ? res + 1 : res;
    }
}

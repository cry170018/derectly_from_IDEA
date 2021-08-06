package Window;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubString {
    //滑动窗口的模板
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int l = 0, r = 0;
        int ans = 0, res = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {

            //增大窗口
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                ans++;
            }

            //存数
            res = Math.max(res, ans);

            //减小窗口
            while (l < r && r < s.length() && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
                ans--;
            }
        }

        return res;


    }
}

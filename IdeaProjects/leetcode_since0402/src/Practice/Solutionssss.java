package Practice;

import java.util.ArrayList;
import java.util.Stack;

public class Solutionssss {

    public static void main(String[] args) {

        System.out.println(search(new int[]{1, 3}, 0));

    }


    public static int search(int[] nums, int target) {
        int idx = -1, len = nums.length;
        if (len == 1 && nums[0] != target) return -1;
        if (len == 1 && nums[0] == target) return 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }


        if ((idx != (-1)) && (target < nums[idx] || target > nums[idx - 1])) return -1;
        int l = 0, r = 0;
        if (idx == -1) {
            l = 0;
            r = len;
        } else {
            if (target > nums[0]) {
                l = 0;
                r = idx;
            }
            if (target < nums[len - 1]) {
                l = idx;
                r = len;
            }
        }

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target < nums[mid]) r = mid;
            if (target > nums[mid]) l = mid + 1;
            if (target == nums[mid]) return mid;
        }
        return -1;

    }


    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (cs[i] == '(' || cs[i] == '{' || cs[i] == '[') {
                stk.push(cs[i]);
            } else if (isCouple(stk.peek(), cs[i])) {
                stk.pop();
                continue;
            } else return false;

        }


        return stk.isEmpty();

    }

    static boolean isCouple(char c, char s) {
        if (c == '(' && s == ')') return true;
        if (c == '[' && s == ']') return true;
        if (c == '{' && s == '}') return true;
        return false;
    }
}

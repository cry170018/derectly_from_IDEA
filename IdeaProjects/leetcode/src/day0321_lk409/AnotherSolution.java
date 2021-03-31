package day0321_lk409;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnotherSolution {
    public int longestPalindrome(String s) {
        int[] array = new int[58];

        int res = 0;
        for (char c : s.toCharArray()) {
            array[c - 'A']++;
        }
        for (int i = 0; i < array.length; i++) {
            res += array[i] / 2 * 2;
            if (array[i] % 2 == 1 && res % 2 == 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {

        String aaa = "abcdefg";
        System.out.println(aaa.substring(1, 5));
        System.out.println(new AnotherSolution().longestPalindrome(aaa));
    }
}

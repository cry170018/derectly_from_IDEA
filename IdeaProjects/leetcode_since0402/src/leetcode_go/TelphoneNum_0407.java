package leetcode_go;

import java.util.ArrayList;
import java.util.List;

public class TelphoneNum_0407 {

    static String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == "") return res;
        char[] digitsString = digits.toCharArray();
        int[] digitsInt = new int[digitsString.length];
        for (int i = 0; i < digitsString.length; i++) {
            digitsInt[i] = digitsString[i] - '0';
        }
        backTracking(digitsString.length, 0, digitsInt);
        return res;
    }

    public void backTracking(int lengthOfNum, int index, int[] digitsInt) {
        if (sb.length() == lengthOfNum) {
            res.add(sb.toString());
            return;
        }
        String str = letterMap[digitsInt[index]];

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(lengthOfNum, index + 1, digitsInt);
            sb.deleteCharAt(sb.length() - 1);
        }


    }

    public static void main(String[] args) {
        TelphoneNum_0407 telphoneNum_0407 = new TelphoneNum_0407();
        List<String> strings = telphoneNum_0407.letterCombinations("");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

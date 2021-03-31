package leetcode04;

//import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class test02 {


/*https://leetcode-cn.com/problems/string-to-integer-atoi/solution/san-chong-fang-fa-zheng-chang-bian-li-you-xian-zhu/*/


    public static void main(String[] args) {
        String s = "      -23ojjh";
        System.out.println(myAtoi(s)+"");
    }

public static int myAtoi(String s){

    AutoMata autoMata = new AutoMata();
    char[] chars = s.toCharArray();
    for (char c : chars) {
        autoMata.get(c);
    }


    return (int)(autoMata.ans*autoMata.sign);
}
    static class AutoMata{
        private String state = "start";
        //状态机下一状态索引
        Map<String,String[]> table = new HashMap<>(){
            {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
        };

        int sign = 1;//符号位默认为正数
        long ans = 0;

        public int getstate (char c){
            if(c==' ') return 0;
            if(c=='+'||c=='-') return 1;
            if(Character.isDigit(c)) {

                return 2;}
            return 3;
            }


        public void get(char c){

           // 把下一状态的值确定
            state = table.get(state)[getstate(c)];
            if(state == "in_number"){
                ans =ans *10 +(c -'0');
                //正数选小的，负数选大的-->选出不溢出的最大值
                ans = sign==1?Math.min(ans,(long)Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);

            }
            if(state == "signed"){
                sign= c=='+'?1:-1;
            }


        }



    }








}

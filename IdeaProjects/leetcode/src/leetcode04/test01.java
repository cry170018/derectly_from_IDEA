package leetcode04;


import java.util.ArrayList;

public class test01 {

    public static void main(String[] args) {
        String s = "   -45";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s){
        int result = 0;
        String result_String = null;
        boolean start_flag = false;
        ArrayList<Character> result_arrays= new ArrayList<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        for (char aChar : chars) {
            if (aChar == ' '){
                continue;
            }
            if((aChar=='+'||aChar=='-')&&start_flag ==false){
                result_arrays.add(aChar);
                start_flag = true;
                continue;
            }
            if((48<aChar||aChar<57)&&start_flag==false){
                result_arrays.add(aChar);
                start_flag = true;
                continue;
            }
            if(start_flag==true){
                if(48<aChar||aChar<57){
                    result_arrays.add(aChar);
                    continue;
                }else break;



            }

        }
        result_String = result_arrays.toString();
        System.out.println(result_arrays);

        System.out.println("string结果为"+result_String);
        System.out.println(result_String.length());

        //result=Integer.parseInt(result_String);

        return result;
    }
}

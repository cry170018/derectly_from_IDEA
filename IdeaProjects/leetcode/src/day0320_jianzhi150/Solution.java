package day0320_jianzhi150;


import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String>stk = new Stack<>();
        int leftNum,rightNum;
        for(int i=0;i<tokens.length;i++){
            if(!"+".equals(tokens[i])&&!"-".equals(tokens[i])&&!"*".equals(tokens[i])&&!"/".equals(tokens[i])){
                stk.push(tokens[i]);
            }else{
                rightNum = Integer.parseInt(stk.pop());
                leftNum = Integer.parseInt(stk.pop());

                switch(tokens[i]){
                    case "+":stk.push( Integer.toString((leftNum+rightNum)));break;
                    case "-":stk.push(Integer.toString((leftNum-rightNum)));break;
                    case "*":stk.push(Integer.toString((leftNum*rightNum)));break;
                    case "/":stk.push(Integer.toString((leftNum/rightNum)));break;
                    default:break;
                }
            }
        }
        return Integer.parseInt(stk.pop());
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}/*{"4","13","5","/","+"}*/);
        System.out.println(i);
    }
}

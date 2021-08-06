package Practice;

import java.util.Stack;

public class Solutionssss {

    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] cs =  s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(cs[i]=='('||cs[i]=='{'||cs[i]=='['){
                stk.push(cs[i]);
            }else if(isCouple(stk.peek(),cs[i])){
                stk.pop();
                continue;
            }else return false;

        }


            return stk.isEmpty();

    }

    static boolean isCouple(char c,char s){
        if(c=='('&&s==')')return true;
        if(c=='['&&s==']')return true;
        if(c=='{'&&s=='}')return true;
        return false;
    }
}

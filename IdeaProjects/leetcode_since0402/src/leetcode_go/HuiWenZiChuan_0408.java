package leetcode_go;

import java.util.*;

public class HuiWenZiChuan_0408 {
    /*分割回文串*/
    List<List<String>>res = new ArrayList<>();
    List<String> path = new ArrayList<>();


    public List<List<String>> partition(String s) {

        if(s.length()==0)return res;
        backTracking(s,0);
        return res;
    }

    void backTracking(String s,int startIndex){
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <s.length() ; i++) {
            if(isHuiWenPartition(s.substring(startIndex,i+1))){
                String str = s.substring(startIndex,i+1);
                path.add(str);
            } else continue;
            backTracking(s,i+1);
            path.remove(path.size()-1);
        }

    }
    boolean isHuiWenPartition(String s){

        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))return false;
        }
        return true;

    }

    public static void main(String[] args) {
        HuiWenZiChuan_0408 huiWenZiChuan_0408 = new HuiWenZiChuan_0408();
        List<List<String>> res = huiWenZiChuan_0408.partition("aab");
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println("===");
        }

    }
}

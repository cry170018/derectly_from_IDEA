package backtracking;


import java.util.HashSet;
import java.util.Set;

class StringPailie {
        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[8];
        public String[] permutation(String s) {
            char[] chars = s.toCharArray();


            dfs(chars,0,"");


            String[] res = new String[set.size()];
            int idx = 0;
            for (String str : set) res[idx++] = str;
            return res;
        }

        void dfs(char[]chars,int curIndex,String cur){
            if(curIndex==chars.length){
                set.add(cur);
                return;
            }

            for(int i=0;i<chars.length;i++){
                if(used[i]==false){
                    used[i] = true;
                    dfs(chars,curIndex+1,cur+String.valueOf(chars[i]));
                    used[i] = false;
                }
            }
        }


    }


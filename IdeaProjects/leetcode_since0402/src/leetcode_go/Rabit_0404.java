package leetcode_go;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Rabit_0404 {


        public int numRabbits(int[] answers) {
            if(answers.length==0)return  0;
            Arrays.sort(answers);
            System.out.println(Arrays.toString(answers));
            int ans = 0;
            for(int i=0;i<answers.length;i++){
                int num = answers[i]+1;//该颜色的兔子数量
                int k = num-1;
                //跳过num-1个该数字
                while(k-->0&&i<answers.length-1&&num-1==answers[i+1])i++;
                //当前k大于0，且不是最后一个i，且下一个也是该值，我才++，否则交还for来+
                ans+=num;
            }

            return ans;
        }
//public int numRabbits(int[] cs) {
//    Arrays.sort(cs);
//    int n = cs.length;
//    int ans = 0;
//    for (int i = 0; i < n; i++) {
//        int cnt = cs[i];
//        ans += cnt + 1;
//        // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」
//        int k = cnt;
//        while (k-- > 0 && i + 1 < n && cs[i] == cs[i + 1]) i++;
//    }
//    return ans;
//}



    public static void main(String[] args) {
        Rabit_0404 rabit_0404 = new Rabit_0404();
        int[] arr ={1,2,4,2,2};
        int i = rabit_0404.numRabbits(arr);
        System.out.println(i);
    }
    }




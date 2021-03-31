package leetcode03;
/*将数字翻转，并且防止溢出*/
/*使用数字计算法效率高于使用字符反转*/
/*时间复杂度：O(log(x))，x中大约有 log10(x) 位数字。
空间复杂度：O(1)

作者：LeetCode
链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
public class newtest {
    public static void main(String[] args) {

        long x= -22255566;
        System.out.println(fanzhuan(x));

    }

    private static long fanzhuan(long x) {
        long ans=0;
        long pop =0;
        while(x!=0){
            pop=x%10;
            if(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            ans=ans*10+pop;
            x=x/10;
        }
      return ans;
    }
}

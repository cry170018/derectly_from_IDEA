package day0311_jianzhi10;

public class Solution {
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int a = 0, b = 1, sum=a+b;
        for(int i = 2; i < n; i++){
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        Solution solution = new Solution();
        int fib = solution.fib(n);
        System.out.println(fib);
    }

}

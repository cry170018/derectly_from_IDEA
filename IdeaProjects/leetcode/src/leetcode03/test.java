package leetcode03;

/*将数字翻转，并且防止溢出*/

public class test {
    public static void main(String[] args) {
        long x= 2147483647;
        method(x);

        }

    private static void method(long x) {


        String string;
        if(x>0) string = x + "";
        else   string = -x +"";

        StringBuilder stringBuilder = new StringBuilder(string);
        StringBuilder reverse = stringBuilder.reverse();

        String string1 = reverse.toString();
        if(x<0){string1 = "-"+string1;}

        System.out.println(string1);
        long ans = Long.parseLong(string1);
        try {
            System.out.println(ans);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}

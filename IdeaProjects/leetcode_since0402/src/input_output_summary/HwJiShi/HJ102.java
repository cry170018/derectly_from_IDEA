package input_output_summary.HwJiShi;

import java.util.*;


//记录char出现的次数，并自定规则排序
public class HJ102 {
    private final int N = 127;

    public static void main(String[] args) {

        HJ102 hw = new HJ102();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String ans = hw.count(s);
            System.out.println(ans);
        }
    }

    class Pair {
        private int value;
        private int times;

        public Pair(int value, int times) {
            this.value = value;
            this.times = times;
        }


    }

    public String count(String s) {
        int[] arr = new int[N];
        for (char c : s.toCharArray()) {
            if (c >= N) continue;
            arr[c]++;
        }

        PriorityQueue<Pair> que = new PriorityQueue<>((o1, o2) -> {
            if (o1.times == o2.times) return o1.value - o2.value;
            return o2.times - o1.times;
        });

        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) que.add(new Pair(i, arr[i]));
        }

        StringBuilder sb = new StringBuilder();

        while (!que.isEmpty()){
            sb.append((char)que.poll().value);
        }


        return sb.toString();
    }
}

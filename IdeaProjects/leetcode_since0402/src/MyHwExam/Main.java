package MyHwExam;

import java.util.*;


/*必须是Main*/
public class Main {

    static int m_res;

    //T1
    public static void main(String[] args) {
        Main main = new Main();

        int max = 0;
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                arr[i][j] = sc.nextInt();

            }
        }

        System.out.println(max);

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0) {
                    m_res = 0;
                    main.dfs(arr, i, j);
                    max = Math.max(max, m_res);
                }
            }
        }


    }



    void dfs(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0) {

            return;
        }
        m_res += arr[i][j];
        arr[i][j] = 0;

        dfs(arr, i + 1, j);
        dfs(arr, i, j + 1);
        dfs(arr, i - 1, j);
        dfs(arr, i, j - 1);
    }


    public static int countMaxActivity(ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        //[["10:00","12:00"],["03:00","11:30"],["11:30","14:00"]]
        int len = timeSchedule.size();
        int[][][] timeStrs = new int[len][2][2];
        int idx = 0;
        for (ArrayList<String> arrayList : timeSchedule) {
            String[] split = arrayList.get(0).split(":");
            timeStrs[idx][0][0] = Integer.valueOf(split[0]);
            timeStrs[idx][0][1] = Integer.valueOf(split[1]);

            String[] split1 = arrayList.get(1).split(":");
            timeStrs[idx][1][0] = Integer.valueOf(split1[0]);
            timeStrs[idx][1][1] = Integer.valueOf(split1[1]);

            idx++;
        }
        Arrays.sort(timeStrs, new Comparator<int[][]>() {
            @Override
            public int compare(int[][] o1, int[][] o2) {
                if (o1[0] == o2[0]) return o1[1][1] - o2[1][1];
                return o1[0][0] - o2[0][0];
            }
        });


//        System.out.println();


        return 0;


    }


    //T2
    public static int findMin(int[][] mapArray) {
        // write code here
        int m = mapArray.length;
        int n = mapArray[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = mapArray[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = mapArray[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = mapArray[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + mapArray[i][j];
            }
        }


        return dp[m - 1][n - 1];
    }

    //T3
    public static int[] max_version(String[][] version_list) {
        // write code here
        int len = version_list.length;
        int[] ans = new int[len];

        for (int i = 0; i < version_list.length; i++) {
            String aaa = version_list[i][0];
            String bbb = version_list[i][1];


            int size = Math.min(aaa.length(), bbb.length()) / 2 + 1;
            for (int j = 0; j < size; j++) {
                if (version_list[i][0].charAt(j * 2) > version_list[i][1].charAt(j * 2)) {
                    ans[i] = 1;
                    break;
                } else if (version_list[i][0].charAt(j * 2) < version_list[i][1].charAt(j * 2)) {
                    ans[i] = 2;
                    break;
                }
            }
            if (ans[i] == 0) ans[i] = 1;
        }

        return ans;

    }

    public static int[] max_version______(String[][] version_list) {
        // write code here
        int len = version_list.length;
        int[] ans = new int[len];

        for (int i = 0; i < version_list.length; i++) {
            String aaa = version_list[i][0];
            String[] split1 = version_list[i][0].split("\\.");
            String[] split2 = version_list[i][1].split("\\.");
            int size = Math.min(split1.length, split2.length);
            for (int j = 0; j < size; j++) {
                if (Integer.valueOf(split1[j]) > Integer.valueOf(split2[j])) {
                    ans[i] = 1;
                    break;
                } else if (Integer.valueOf(split1[j]) < Integer.valueOf(split2[j])) {
                    ans[i] = 2;
                    break;
                }
            }
            if (ans[i] == 0) ans[i] = 2;
        }

        return ans;

    }


    public static List<Integer> pathInZigZagTree(int label) {

        ArrayList<Integer> que = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int curLevel = 1;
        int cur = 1;

        while (Math.pow(2, curLevel - 1) - 1 < label) {
            //正序
            int max = (int) Math.pow(2, curLevel) - 1;
            int min = (int) Math.pow(2, curLevel - 1);
            if (curLevel % 2 == 1) {
                for (int i = min; i <= max; i++) {
                    que.add(i);
                    if (i == label) break;
                }
            } else {
                for (int i = max; i >= min; i--) {
                    que.add(i);
                    if (i == label) break;
                }
            }

            curLevel++;

        }
        int idx = que.size() - 1;

        while (idx > 0) {
            ans.add(que.get(idx));
            idx = (idx - 1) / 2;
        }
        ans.add(que.get(0));

        Collections.reverse(ans);
        return ans;


    }

    public void Hw0721T2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.valueOf(strings[j]);
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });

//        PriorityQueue<int[]> que = new PriorityQueue<>(K, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1]) return o2[0] - o1[0];
//                return o1[1] - o2[1];
//            }
//        });
        Queue<int[]> que = new LinkedList<>();
        int len = 0;
        int i = 0;
        while (i < arr.length) {
            while (len < 10) {
                que.offer(arr[i++]);
                len++;
            }
            while (true) {
                boolean flag = false;
                for (int i1 = 0; i1 < que.size(); i1++) {
                    int[] thisEle = que.poll();
                    thisEle[0]--;
                    if (thisEle[0] == 0) flag = true;
                    que.offer(thisEle);
                }
                if (flag) break;

            }

        }


    }


    //https://www.nowcoder.com/discuss/688679?type=post&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack
    //华为0721笔试第一题
    public void Hw0721T1() {
        Scanner sc = new Scanner(System.in);
        int staNum = sc.nextInt();
        int cliNum = sc.nextInt();
        //上车时间，上车车站，下车车站
        int[][] arr = new int[cliNum][3];
        for (int i = 0; i < cliNum; i++) {
            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.valueOf(strings[j]);
            }
        }


        //长度=上车时间+（下-上）*5
        int[][] region = new int[cliNum][2];
        int idx = 0;
        for (int i = 0; i < cliNum; i++) {
            region[i][0] = arr[i][0];
            region[i][1] = Math.min(arr[i][2] - arr[i][1], staNum - (arr[i][2] - arr[i][1])) * 5 + region[i][0];

        }
        Arrays.sort(region, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int lastEnd = region[0][1];
        int ans = 0;
        for (int i = 0; i < cliNum; i++) {
            if (region[i][0] == region[i][1]) continue;
            if (region[i][0] < lastEnd) {
                ans++;
                lastEnd = region[i][1];
            } else {
                lastEnd = Math.max(lastEnd, region[i][1]);
            }
        }

        System.out.println(ans);
    }


    void zuiYou2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        for (int i = 1; ; i++) {
            if (!set.contains(i))
                System.out.println(i);
            break;

        }
    }

    public void zuiYou() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ud = new int[n][2];
        int[] c = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ud[i][0] = sc.nextInt();//u
            ud[i][1] = sc.nextInt();//d
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    temp += (j - i) * ud[j][1] * c[j];
                } else {
                    temp += (i - j) * ud[j][0] * c[j];
                }

            }
            ans = Math.min(ans, temp);
//            System.out.println();
        }

        System.out.println(ans);
    }


    public String findMinOverrideSubString111(String source, String target) {
        // write code here

        if (source == null || source.length() == 0 || target == null || target.length() == 0) return "";
        int[] need = new int[128];
        for (int i = 0; i < target.length(); i++) {
            need[target.charAt(i)]++;
        }
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = target.length(), start = 0;
        while (r < source.length()) {
            char c = source.charAt(r);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;
            if (count == 0) {
                while (l < r && need[source.charAt(l)] < 0) {
                    need[source.charAt(l)]++;
                    l++;
                }
                if (r - 1 + l < size) {
                    size = r - l + 1;
                    start = l;
                }

                need[source.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }

        return size == Integer.MAX_VALUE ? "" : source.substring(start, start + size);
    }

    public int[] GetEndPoint1(String order) {
        // write code here
        char[] cs = order.toCharArray();
        int len = cs.length;
        int idx = 0;
        int[] ans = new int[2];
        if (len == 0) return ans;
        int n = 1;
        while (idx < len) {
            if (Character.isDigit(cs[idx])) {
                n = cs[idx] - '0';
            } else if (cs[idx] == 'W') {

                ans[1] += n;

            } else if (cs[idx] == 'S') {

                ans[1] -= n;

            } else if (cs[idx] == 'A') {

                ans[0] -= n;


            } else if (cs[idx] == 'D') {

                ans[0] += n;

            }
            idx++;

        }
        return ans;

    }


    public int[] GetEndPoint(String order) {
        // write code here
        char[] cs = order.toCharArray();
        int n = cs.length;
        int idx = 0;
        int[] ans = new int[2];
        if (n == 0) return ans;

        Stack<Character> stack = new Stack<>();
        while (idx < n) {
            if (cs[idx] <= '9' && cs[idx] >= '2') {
                stack.push(cs[idx]);
                idx++;
                continue;
            }
            if (cs[idx] == 'W') {
                if (!stack.isEmpty()) {

                    ans[1] += stack.pop() - '0';
                } else {
                    ans[1]++;
                }
            } else if (cs[idx] == 'S') {
                if (!stack.isEmpty()) {
                    ans[1] -= stack.pop() - '0';
                } else {
                    ans[1]--;
                }
            } else if (cs[idx] == 'A') {
                if (!stack.isEmpty()) {
                    ans[0] -= stack.pop() - '0';
                } else {
                    ans[0]--;
                }
            } else if (cs[idx] == 'D') {
                if (!stack.isEmpty()) {
                    ans[0] += stack.pop() - '0';
                } else {
                    ans[0]++;
                }
            }
            idx++;

        }
        return ans;

    }

    public static int getValue(int rowIndex, int columnIndex) {
        // write code here
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }

        return ans.get(rowIndex).get(columnIndex);
    }

    public String findMinOverrideSubString(String source, String target) {
        // write code here

        int sLen = source.length(), tLen = target.length();
        int[] hash = new int[128];
        for (char ch : target.toCharArray()) {
            hash[ch]--;
        }
        String ans = "";

        for (int le = 0, ri = 0, cnt = 0; ri < sLen; ri++) {
            if ((++hash[source.charAt(ri)]) <= 0) {
                cnt++;
            }

            while (cnt == tLen && hash[source.charAt(le)] > 0) {
                hash[source.charAt(le++)]--;
            }

            if (cnt == tLen) {
                if (ans.equals("") || ans.length() > ri - le + 1) {
                    ans = source.substring(le, ri + 1);
                }
            }
        }

        return ans;
    }


    public String reverseNum(String str) {
        int len = str.length();
        char[] arr = new char[3 * len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = ch;
            }
        }

        return new String(arr, 0, size);

    }

}

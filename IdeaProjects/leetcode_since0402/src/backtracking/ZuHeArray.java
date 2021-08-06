package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ZuHeArray {
    List<List<Integer>> res = new ArrayList<>();//结果集
    List<Integer> path = new ArrayList<>();//路径集

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        backTracking(candidates, target, 0, 0);
        return res;
    }

    void backTracking(int[] candidates, int target, int curSum, int startIndex) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(path));//找到则加入结果集
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {//注意什么时候要用起始位置，什么时候不用
            curSum += candidates[i];//选择
            path.add(candidates[i]);//选择
            backTracking(candidates, target, curSum, i);//这里的i没有+1体现这个数在下一层还能用
            path.remove(path.size() - 1);//回溯
            curSum -= candidates[i];//回溯
        }
    }
}

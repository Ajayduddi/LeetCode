// https://leetcode.com/problems/combination-sum/description/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] data = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> ans = combinationSum(data, target);
        System.out.println(ans);
    }
    
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0, 0, ans);
        return ans;
    }

    static public void helper(int[] data, int target, List<Integer> p, int sum, int index,List<List<Integer>> ans) {
        // base condition 
        if(sum == target){
            List<Integer> ans2 = new ArrayList<>();
            ans2.addAll(p);
            ans.add(ans2);
            return;
        }
    
        int j = index;
        while (j < data.length) {
            p.add(data[j]);
            sum += data[j];
            if (sum <= target) {
                helper(data, target, p, sum, j,ans);
            }
            // backtracking
            sum -= data[j];
            p.remove(p.size() - 1);
            j++;
        }

        return;
    }
}

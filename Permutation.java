// https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[] { 1, 2, 3 });
        System.out.println(list);
    }
    
    static public List<List<Integer>> permute(int[] nums) {
        return helper(nums, new ArrayList<>(),0);
    }

    public static List<List<Integer>> helper(int[] up, List<Integer> p, int index) {
        // after find solution
        if (index == up.length) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(p);
            return new ArrayList<>(List.of(ans));
        }

        int ch = up[index];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= p.size(); i++) {
            // add ch to p
            p.add(i,ch);
            List<List<Integer>> temp = helper(up, p, index + 1);
            p.remove(i); // backtrack
            ans.addAll(temp);
        }

        return ans;
    }
}

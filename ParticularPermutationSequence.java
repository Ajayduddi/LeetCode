// https://leetcode.com/problems/permutation-sequence/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticularPermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutationOptimal(4, 9));
    }
    
    /*
     * brute force solution
     * time complexity: O(n!.n)
     * There are 𝑛! permutations for n numbers.
     * Generating each permutation has a time complexity of O(n).
    */
    static public String getPermutation(int n, int k) {
        StringBuilder data = new StringBuilder();

        for (int i = 0; i < n; i++) {
            data.append(i + 1);
        }

        int no = 1;
        for (int i = 1; i <= n; i++) {
            no *= i;
        }

        String[] str = new String[no];

        helper(new String(), new String(data), str);
        Arrays.sort(str);
        return str[k - 1];
    }

    static int count = 0;

    public static void helper(String p, String up, String[] ans) {
        // base condition
        if (up.isEmpty()) {
            ans[count] = p;
            count++;
            return;
        }

        char ch = up.charAt(0);
        for (int i = p.length(); i >= 0; i--) {
            String first = p.substring(0, i);
            String last = p.substring(i, p.length());
            helper(first + ch + last, up.substring(1), ans);
        }
    }

    
    /*
     * Optimal Solution
     * time complexity: O(n^2)
     */
    static public String getPermutationOptimal(int n, int k) {
        StringBuilder ans = new StringBuilder();

        // factorial array
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // digit array
        List<Integer> digit = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digit.add(i);
        }

        // reduce the k value by 1 [ because index start from 0 ]
        k--;

        helperOptimal(n, k, factorial, digit, ans);
        return ans.toString();
    }
    
    public static void helperOptimal(int n, int k, int[] factorial, List<Integer> digit, StringBuilder ans) {
        // After find solution
        if (n == 0) {
            return;
        }

        // if 1 digit is left in the digit array
        if (n == 1) {
            ans.append(digit.get(0));
            n = n - 1;
            return;
        }

        // find permutation
        int index = k / factorial[n - 1]; // ffind index of which digit is appended
        ans.append(digit.get(index)); // append the digit to ans
        digit.remove(index); // remove the digit from digit array

        // find the next digit
        k = k % factorial[n - 1]; // reduce k value for find next digit
        n = n - 1; // reduce n value by 1 [ because already start digit is found]

        helperOptimal(n, k, factorial, digit, ans);
    }

}

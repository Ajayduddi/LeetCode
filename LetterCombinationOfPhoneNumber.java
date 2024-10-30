// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }
    
    static public List<String> letterCombinations(String digits) {
        Map<Integer,String> data = new HashMap<>();
        data.put(2,"abc");
        data.put(3,"def");
        data.put(4,"ghi");
        data.put(5,"jkl");
        data.put(6,"mno");
        data.put(7,"pqrs");
        data.put(8,"tuv");
        data.put(9, "wxyz");

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        helper(new String(), digits, data, ans);

        return ans;
    }

    static public void helper(String p, String up, Map<Integer, String> data, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        int num = up.charAt(0) - '0';
        String letter = data.get(num);

        for (int i = 0; i < letter.length(); i++) {
            helper(p + letter.charAt(i), up.substring(1), data, ans);
        }
    }
}
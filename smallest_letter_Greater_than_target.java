// You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

// solved using binary search
// Time Complexity: O(log n)

public class smallest_letter_Greater_than_target {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start <= (letters.length - 1) ? letters[start] : letters[0];
    }
    
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'z';
        System.out.println(new smallest_letter_Greater_than_target().nextGreatestLetter(letters, target));
    }
}



// Example 1:
// Input: letters = ["c","f","j"], target = "a"
// Output: "c"
// Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

// Example 2:
// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

// Example 3:
// Input: letters = ["x","x","y","y"], target = "z"
// Output: "x"
// Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
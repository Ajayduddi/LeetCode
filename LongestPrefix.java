import java.util.Arrays;

public class LongestPrefix {
    
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }
    
    /*
     * A prefix is a collection of characters at the beginning of a string. For instance, “mi” is a prefix of “mint” and 
     * the longest common prefix between “mint”, “mini”, and “mineral” is “min”.
     * In order to find the longest common prefix, we sort the array of strings alphabetically. 
     * Then, we compare the characters in the first and last strings in the array. 
     * If the character in first is in last at the corresponding index, the character must be in the remaining words at the corresponding index as well,
     * because the array of strings have already been sorted.
     */
    
    static public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int i = 0;
        int j = strs.length - 1;
        StringBuilder pre = new StringBuilder();

        for(int k=0; k<strs[i].length(); k++){
            if(strs[i].charAt(k) == strs[j].charAt(k)){
                pre.append(strs[i].charAt(k));
            }
            else{
                break;
            }
        }

        return pre.toString();
    }
}

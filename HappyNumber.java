import java.util.HashMap;
import java.util.Map;

/*
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
// https://leetcode.com/problems/happy-number/description/

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    
    static public boolean isHappy(int n) {
        Map<Integer,Boolean> hash = new HashMap<>();

        hash.put(n,true);
        int sum = happy(n);
        while(true){
            if(sum == 1){
                return true;
            }
            else if(!hash.containsKey(sum)){
                hash.put(sum,true);
                sum = happy(sum);
            }
            else{
                break;
            }
        }

        return false;
    }

    static public int happy(int n){
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n = n / 10;
        }

        return sum;
    }
}

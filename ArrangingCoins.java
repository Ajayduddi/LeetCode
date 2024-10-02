/**
 * ArrangingCoins
 * 
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the ith row has exactly i coins. The last
 * row of the staircase may be incomplete.
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * 
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

    public static void main(String[] args) {
        int n = 1804289383; // 60070
        System.out.println(arrangeCoins(n));
    }

    // using binary sarch
    static public int arrangeCoins(int n) {
        int start = 0;
        int end = n;

        // No of coins required to build n rows = n * (n + 1) / 2
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long coins = ((long)mid * (mid + 1)) / 2;

            if (coins == n)
                return mid;
            else if (coins > n)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start - 1;
    }


    // This is the simple solution
    // first take row is equal to 0
    // and then set the condition that n>=row+1
    // if this satisfy then do row++ and n--;
    // simple at last return row;

    static public int arrangeCoins2(int n) {
        int row = 0;
        while (n >= row + 1) {
            row++;
            n -= row;
        }
        return row;
    }

}
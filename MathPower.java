//using recrusion

/**
 * MathPower
 * Time complexity = O(log n)
 * space complexity = O(log n)
 * 
 * https://leetcode.com/problems/powx-n/description/
 */
public class MathPower {

    public static void main(String... args) {
        System.out.println(myPow(-1.00000, 2147483647));
    }

    static public double myPow(double x, int n) {

        // Handle the case where n is the minimum int value
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) {
            // Divide n by 2 to prevent overflow, and adjust the result accordingly
            if (x < 0) {
                x = -x * x;
            } 
            else {
                x = x * x;
            }
            n = n / 2;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        } 
        else if (n == 0) {
            return 1;
        } 
        else if (x == 1) {
            return 1;
        } 
        else if (n == 1) {
            return x;
        }

        // here we decrease the n size into half, so after receiveing the half part
        // value we have to return the square of that value
        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return x * result * result;
        }
    }
}
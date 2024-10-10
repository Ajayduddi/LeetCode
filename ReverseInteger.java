// https://leetcode.com/problems/reverse-integer/description/

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    static public int reverse(int x) {
        int ans = 0;
        if( x<Integer.MAX_VALUE && x>Integer.MIN_VALUE ){
            if(x>0){
            ans = intreverse(x);
            }
            else if(x<0){
                x = Math.abs(x);
                ans = -1 * intreverse(x);
            }
        }

        return ans;
    }

    static public int intreverse(int x){
        long ans = 0;
        boolean start = false;
        while (x != 0) {
            int rem = x % 10;
            if (rem != 0) {
                start = true;
            }
            if (start) {
                ans = ans * 10;
                ans = ans + rem;
            }
            x /= 10;
        }
        
        if (ans > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)ans;
    }
}

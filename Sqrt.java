// https://leetcode.com/problems/sqrtx/

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(222));
    }
    
    static public int mySqrt(int x) {
        int start = 0;
        int end = x;

        if (x > 1) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int root = x / mid;

                if (root == mid) {
                    return mid;
                } else if (root < mid)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            return end;
        }
        else if (x == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

/**
 * PerfectSquare
 */
public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(99_856));
    }
    
    static public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;

        if(num == 0 || num == 1){
            return true;
        }
        else{
            while(start<=end){
            int mid = start+(end-start)/2;
            double root = num / mid;
            int rem = num % mid; 
 
            if(root==mid && rem==0) return true;
            else if (root<mid) end = mid-1;
            else start = mid+1;

        }
        }

        return false;
    }
}
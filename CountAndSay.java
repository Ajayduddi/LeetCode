import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CountAndSay
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    
    static public String countAndSay(int n) {
        String s = new String("1");
        if(n == 1){
            return "1";
        }

        for(int i=2; i <= n; i++){
            List<List<Integer>> arr = array(s);
            s = str(arr);
        }

        return s;
    }

    static public List<List<Integer>> array(String s){
        List<List<Integer>> arr = new ArrayList<>();

        int count = 1, i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i++;
            } else {
                arr.add(Arrays.asList(count, s.charAt(i - 1) - '0'));
                count = 1;
                i++;
            }
        }
        arr.add(Arrays.asList(count,s.charAt(i-1) - '0'));

        return arr;
    }

    static public String str(List<List<Integer>> arr){
        StringBuilder s = new StringBuilder();

        for(int i=0; i<arr.size(); i++){
            s.append(arr.get(i).get(0));
            s.append(arr.get(i).get(1));
        }

        return new String(s);
    }
}
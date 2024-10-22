/**
 * StringToInteger
 * 
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775809"));
    }
    
    static public int myAtoi(String s) {
        s = s.trim();
        long result = 0;
        
        boolean isNegative = false;
        int i=0;
        int size = s.length();
        boolean isChange = false;

        while(i<size && s.charAt(i) == '-'){
            isNegative = true;
            i++;
            break;
        }

        if(!isNegative){
            if(i<size && s.charAt(i) == '+'){
                i++;
            }
        }

        while(i<size && s.charAt(i) == '0' ){
            i++;
        }

        while(i<size){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                break;
            }
            /* str.charAt(index) - '0' is to convert the char digit into int digit eg: '5' - '0' --> 5
      or else it will store the ASCII value of 5 i.e. 53,
      so we do 53(ASCII of 5) - 48(ASCII of 0(zero)) to get 5 as int*/
            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;
            if(!isChange && result > Integer.MAX_VALUE){
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        
        result = isNegative? -result: result;

        return (int)result;

    }
}
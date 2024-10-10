// https://leetcode.com/problems/bulls-and-cows/description/

public class BullsCows {
    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }
    
    static public String getHint(String secret, String guess) {
        int bull = 0,cow=0;
        StringBuilder sec = new StringBuilder();
        StringBuilder gue = new StringBuilder();

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }
            else{
                sec.append(secret.charAt(i));
                gue.append(guess.charAt(i));
            }
        }

        int i=0,j=0;
        while(i<sec.length()){
            if(sec.charAt(i) == gue.charAt(j)){
                sec.deleteCharAt(i);
                gue.deleteCharAt(j);
                cow++;
                j = 0;
            } else {
                j++;
            }
            
            if(i<sec.length() && j>=gue.length()){
                sec.deleteCharAt(i);
                j=0;
            }
        }

        String s = bull+"A"+cow+"B";

        return s;
    }
}

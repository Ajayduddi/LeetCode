import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(100));
    }

    static public String intToRoman(int num) {
        Map<Integer, String> sys = new HashMap<>();
        StringBuilder rom = new StringBuilder();
        sys.put(1, "I");
        sys.put(5, "V");
        sys.put(10, "X");
        sys.put(50, "L");
        sys.put(100, "C");
        sys.put(500, "D");
        sys.put(1000, "M");

        int i = 1;
        while (num != 0) {
            int rem = num % 10;
            rem = rem * i;
            i = i * 10;
            find(rem, rom, sys);
            num /= 10;
        }

        return new String(rom);
    }

    static public void find(int rem, StringBuilder rom, Map<Integer, String> sys) {
        int x = 1;
        if (rem / 10 <= 9 && rem / 10 >= 1)
            x = 10;
        else if (rem / 100 <= 9 && rem / 100 >= 1)
            x = 100;
        else if (rem / 1000 <= 9 && rem / 1000 >= 1)
            x = 1000;

        if (rem == 4 || rem == 9 || rem == 40 || rem == 90 || rem == 400 || rem == 900) {
            rom.insert(0, sys.get(rem + x));
            rom.insert(0, sys.get(x));
        } else {
            if (!sys.containsKey(rem)) {
                if (rem / x < 4 && rem / x >= 1) {
                    for (int j = x; j <= rem; j += x) {
                        rom.insert(0, sys.get(x));
                    }
                } else {
                    rem = rem - (5 * x);
                    for (int j = x; j <= rem; j += x) {
                        rom.insert(0, sys.get(x));
                    }
                    if (rem > 0) {
                        rom.insert(0, sys.get(5 * x));
                    }
                }
            } else {
                rom.insert(0, sys.get(rem));
            }
        }
    }
}

class Solution {
    // simple and efficient
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // Initialize result
        StringBuilder roman = new StringBuilder();

        // Iterate over the values array
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }
}
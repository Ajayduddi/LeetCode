// https://leetcode.com/problems/zigzag-conversion/
// https://youtu.be/Q2Tw6gcVEwc?si=wxHJNcflaDpmPbsv

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    static public String convert(String s, int numRows) {

        if (numRows == 1) return s;
        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < numRows; i++) {

            int jump = numRows + (numRows - 2);
            int j = i;
            int middleJump = jump - (2 * i);

            while (j < s.length()) {

                s1.append(s.charAt(j));

                if (i == 0 || i == numRows - 1) j += jump;
                else {

                    j += middleJump;
                    if (j < s.length()) {

                        s1.append(s.charAt(j));
                        j += (2 * i);

                    }

                }
            }
        }

        return new String(s1);
    }
}


// For the first and last row . row elements are present at every  (numRows - 1) * 2 th ( or ) numRows + (numRows - 2) th index.
// for middle rows. rows elements are repeated at (numRows - 1 ) * 2 index.
// for zigzag elements. row elements present at 2 * (numRows - 1) - 2 * currentRowIndex
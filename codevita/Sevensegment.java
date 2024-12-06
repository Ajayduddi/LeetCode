/*
 * Toggle Challenge Problem Description Deepika has a challenge for you
 * involving a seven-segment display! Let us see what it is.
 * 
 * Deepika will provide you with the 7-segment display of digits from 0 to 9,
 * each represented in a 3x3 matrix format, all arranged in 3 lines. (Refer
 * input format)
 * 
 * Now, she will present you with a 7-segment display of a number that may be
 * having some faults in it. You are allowed to toggle (LED light either on or
 * off where 0 is off and 1 is on, which again will be turned back to original
 * state) at most one light for each digit at a time, to form new numbers. Print
 * the sum of all the numbers that can be formed.
 * 
 * Constraints 1 <= number of digits in the input number <= 50
 * 
 * Given input number will not start with 0.
 * 
 * All the numbers from 0-9 will be unique in 7-segment display.
 * 
 * Input The first three lines will contain the 3x3 matrix representations
 * (7-segment display) of the digits from 0 to 9. In other words, first three
 * lines consists of a 3*9 matrix consisting of only 1 and 0, where 1 indicates
 * that the LED light is on and 0 means it is off.
 * 
 * The next three lines will show the 7-segment display of the number provided
 * by Deepika.
 * 
 * Output Print the sum of all the numbers that can be formed by toggling the
 * LED lights. If there is any digit in the input number that is invalid and
 * cannot become a valid digit by toggling one light on or off, print "Invalid"
 * 
 * Time Limit (secs) 1
 * 
 * Examples Example 1
 * 
 * Input
 * 
 * 111001111111101111111111111111
 * 
 * 101001001011111010100001111111
 * 
 * 111001111111001111111001111001
 * 
 * 001111111111
 * 
 * 000001111010
 * 
 * 001011111111
 * 
 * Output
 * 
 * 17888
 * 
 * Explanation
 * 
 * The first 3 lines, each having 30 columns represent numbers from 0 to 9. Each
 * 3x3 matrix denoted in either red or green, represents individual numbers. The
 * only purpose of colouring is readability.
 * 
 * com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@7d373bcf:image1.png
 * 
 * Next 3 lines of the input denote the actual LEDs which are to be toggled to
 * solve the actual problem mentioned in description section above.
 * 
 * 
 * Let us number the 9 lights present in each matrix from 1-9. Below are the few
 * possibilities -
 * 
 * 1. Toggle 6th light in first 3*3 matrix, 7th light in second 3*3 matrix. Keep
 * the rest same. Number formed will be 1285. Reset the lights to original.
 * 
 * 2. Toggle 6th light in first 3*3 matrix, 7th light in second 3*3 matrix, 5th
 * light in the third 3*3 matrix and keep the rest same. Number formed will be
 * 1205. Reset the lights to original.
 * 
 * 3. Toggle 6th light in first 3*3 matrix, 7th light in second 3*3 matrix, 4th
 * light in the third 3*3 matrix and keep the rest same. Number formed will be
 * 1235. Reset the lights to original.
 * 
 * 4. Toggle 6th light in first 3*3 matrix, 7th light in second 3*3 matrix, 4th
 * light in the third 3*3 matrix and 6th light in the fourth 3*3 matrix. Keep
 * the rest same. Number formed will be 1233. Reset the lights to original.
 * 
 * ...
 * 
 * ..
 * 
 * All the numbers we can form is {1203, 1205, 1233, 1235, 1283, 1285, 1703,
 * 1705, 1733, 1735, 1783, 1785} and their sum is 17888. Hence print the same.
 * 
 * Example 2
 * 
 * Input
 * 
 * 111001111111101010111111111111
 * 
 * 101001100011111111001001111111
 * 
 * 111001111111001010111001111001
 * 
 * 010111111100
 * 
 * 111101011100
 * 
 * 010111110100
 * 
 * Output
 * 
 * Invalid
 * 
 * Explanation
 * 
 * The first 3 lines, each having 30 columns represent numbers from 0 to 9. Each
 * 3x3 matrix denoted in either red or green, represents individual numbers. The
 * only purpose of colouring is readability.
 * 
 * com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@7d373bcf:image2.png
 * 
 * Next 3 lines of the input denote the actual LEDs which are to be toggled to
 * solve the actual problem mentioned in description section above.
 * 
 * Consider the last 3*3 matrix on lines 4 - 6, which is
 * 
 * 100
 * 
 * 100
 * 
 * 100
 * 
 * Based on the provided seven-segment display for the digits 0 to 9, this digit
 * (matrix) is faulty and cannot be corrected by toggling a single light.
 * Therefore, print "Invalid"
 */

package codevita;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sevensegment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] inputMatrix = new int[3][30];  // Valid digits 0-9 in 7-segment format
        int[][] inputFaultNumber = new int[3][12];  // Faulty input number in 7-segment format

        // Read input for valid digits
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                inputMatrix[i][j] = in.nextInt();
            }
        }

        // Read input for faulty number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < inputFaultNumber[0].length; j++) {
                inputFaultNumber[i][j] = in.nextInt();
            }
        }

        // Parse valid digits into 3x3 matrices
        List<List<Integer>> validDigits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            validDigits.add(extractMatrix(inputMatrix, i * 3));
        }

        // Parse faulty digits into 3x3 matrices
        List<List<Integer>> faultyDigits = new ArrayList<>();
        for (int i = 0; i < inputFaultNumber[0].length / 3; i++) {
            faultyDigits.add(extractMatrix(inputFaultNumber, i * 3));
        }

        // Solve the problem
        long result = solve(validDigits, faultyDigits);

        // Print result
        if (result == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(result);
        }

        in.close();
    }

    // Extracts a 3x3 matrix from the input array
    private static List<Integer> extractMatrix(int[][] input, int startCol) {
        List<Integer> matrix = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                matrix.add(input[i][j]);
            }
        }
        return matrix;
    }

    // Solves the toggle challenge
    private static long solve(List<List<Integer>> validDigits, List<List<Integer>> faultyDigits) {
        List<List<Integer>> possibleNumbers = new ArrayList<>();

        for (List<Integer> faultyDigit : faultyDigits) {
            List<Integer> possibleDigits = findPossibleDigits(validDigits, faultyDigit);
            if (possibleDigits.isEmpty()) {
                return -1;  // Invalid case
            }
            possibleNumbers.add(possibleDigits);
        }

        // Calculate all possible numbers and their sum
        return calculateSum(possibleNumbers);
    }

    // Finds all possible valid digits for a given faulty digit
    private static List<Integer> findPossibleDigits(List<List<Integer>> validDigits, List<Integer> faultyDigit) {
        List<Integer> possibleDigits = new ArrayList<>();

        for (int i = 0; i < validDigits.size(); i++) {
            if (isMatch(validDigits.get(i), faultyDigit)) {
                possibleDigits.add(i);
            }
        }

        return possibleDigits;
    }

    // Checks if a valid digit can be formed by toggling at most one light
    private static boolean isMatch(List<Integer> valid, List<Integer> faulty) {
        int differences = 0;
        for (int i = 0; i < valid.size(); i++) {
            if (!valid.get(i).equals(faulty.get(i))) {
                differences++;
                if (differences > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Calculates the sum of all possible numbers
    private static long calculateSum(List<List<Integer>> possibleNumbers) {
        long totalSum = 0;

        List<String> combinations = generateCombinations(possibleNumbers, "", 0);
        for (String combination : combinations) {
            totalSum += Long.parseLong(combination);
        }

        return totalSum;
    }

    // Generates all combinations of numbers from possible digits
    private static List<String> generateCombinations(List<List<Integer>> possibleNumbers, String current, int index) {
        List<String> combinations = new ArrayList<>();

        if (index == possibleNumbers.size()) {
            combinations.add(current);
            return combinations;
        }

        for (int digit : possibleNumbers.get(index)) {
            combinations.addAll(generateCombinations(possibleNumbers, current + digit, index + 1));
        }

        return combinations;
    }
}


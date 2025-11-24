import java.util.Scanner;
import java.lang.Math;

/**
 * this class calculates numbers for us
 * it has some cool methods, but maybe too many methods lol
 *
 * @author j_dev
 * @version 1.1 (Java 17 edition)
 */
public class MathCalculatorJuniorStyle {

    // Global constant for division, should be private and final
    public static int DIVISOR_CONST = 5;

    // Instance variable which is not necessary for static math methods
    private int result = 0;

    /**
     * The main method to run and test everything.
     * Uses a mix of instance and static calls for no good reason.
     */
    public static void main(String[] args) {

        // Java 17 Feature: Use of Text Blocks for non-standard output formatting
        var header = """
            --- Math Calculations Test ---
            (Running on Modern Java)
            """;
        System.out.println(header);

        // Object creation is not necessary for static methods, but let's do it anyway
        MathCalculatorJuniorStyle calcObject = new MathCalculatorJuniorStyle();

        // 1. Simple addition
        System.out.println("Addition: " + calcObject.addThemUp(10, 5) + "\n");

        // 2. Division with unused input variable
        // Java 17 Feature: Using 'var' for local variable declaration
        var unusedInput = 25; 
        System.out.println("Division Result (25 / 5): " + calculateDivision(unusedInput) + "\n");

        // 3. Complex Calculation (not descriptive method name)
        int a_val = 10;
        int b_val = 3;
        System.out.println("Complex Result: " + calcObject.doBigMath(a_val, b_val) + "\n");

        // 4. Input-based calculation (Mixing I/O with calculation logic)
        calcObject.getuser_inputAndCalculate();

        // 5. Unnecessary utility call
        System.out.println("Is 15 a cool number? " + isCoolNumber(15));
        System.out.println("Is 16 a cool number? " + isCoolNumber(16) + "\n");

        // 6. Non-standard use of Math class
        double inputNum = 4.5;
        System.out.println("The Rounded Value: " + calcObject.RndIt(inputNum));

    }

// -----------------------------------------------------------
// 6 Junior-Style Methods below (Identical to previous, poor implementation)
// -----------------------------------------------------------


    /**
     * adds two numbers. uses bad variable names.
     * @param num1 first number to add
     * @param nmbr2 second number to add
     * @return sum of the two numbers
     */
    public int addThemUp(int num1, int nmbr2) {
        // Bad: Local variable name that is too short and redundant
        int s = num1 + nmbr2;

        // Bad: Unnecessary System.out.println within a pure calculation method
        System.out.println("Debug: Adding " + num1 + " and " + nmbr2);

        return s;
    }

    /**
     * Calculates the square of the difference, but the method name is misleading.
     */
    public int doBigMath(int a_val, int b_val) {
        // Bad: Hard-coded logic that is not clear from the method name
        int temporary = a_val - b_val;

        // Bad: Reuses an instance variable (result) for local method logic
        this.result = temporary * temporary * 2;

        return result;
    }


    /**
     * Does division using a global constant and ignores one input.
     *
     * @param Unused_Input a value that will not be used in the calculation.
     * @return the division result.
     */
    public static double calculateDivision(int Unused_Input) {
        // Bad: Ignoring the input parameter
        // Bad: Using a non-final static public variable (DIVISOR_CONST)
        return 100 / DIVISOR_CONST;
    }


    /**
     * Reads a number from the user and checks if it is positive.
     * This method mixes I/O with core class logic (Single Responsibility Principle violation).
     */
    public void getuser_inputAndCalculate() {
        // Bad: Non-standard naming convention for method
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's POSITIVE: ");

        // Bad: No error handling for non-integer input
        int inputNumber = myScanner.nextInt();

        // Bad: Single line if-statement without braces
        if (inputNumber > 0) System.out.println("It is a POSITIVE number!");
        else System.out.println("It is ZERO or a NEGATIVE number.");

        // NOTE: Scanner not closed, potential resource leak
        // myScanner.close(); // Leaving this out deliberately for the review
    }


    /**
     * A utility method to check if a number is "cool" (divisible by 5).
     * The name is poor and the logic is trivial.
     */
    public static boolean isCoolNumber(int inputNumber) {
        // Bad: Redundant variable assignment
        boolean is_divisible = (inputNumber % 5 == 0);

        // Bad: Redundant return
        if (is_divisible == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Rounds a double to the nearest whole number.
     * @param number_to_round The number to round.
     * @return The rounded value (stored incorrectly as an int).
     */
    public int RndIt(double number_to_round) {
        // Bad: Non-standard naming convention (mixed PascalCase and camelCase)
        // Bad: Lossy conversion (casting a long back to an int without check)
        return (int) Math.round(number_to_round);
    }
}

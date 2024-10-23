package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

    /**
     * Computes the geometric sum for the first n terms in the series
     * 
     * @param n the number of terms to include in the sum
     * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8 ...)
     */
    public static double geometricSum(int n) {
        // Base case: if n is 0, return 0
        if (n == 0) {
            return 0.0;
        }
        // Recursive case: 1/(2^n) + geometricSum(n-1)
        return (1 / Math.pow(2, n)) + geometricSum(n - 1);
    }
    
    /**
     * @param xCenter                       x-coordinate of the center of the circle
     *                                      at the current depth
     * @param yCenter                       y-coordinate of the center of the circle
     *                                      at the current depth
     * @param radius                        radius of the circle at the current depth
     * @param radiusMinimumDrawingThreshold radius above which drawing should occur
     */
    public static void circlesUponCircles(double xCenter, double yCenter, double radius,
            double radiusMinimumDrawingThreshold) {
        // Base case: if the radius is smaller than the threshold, stop drawing
        if (radius < radiusMinimumDrawingThreshold) {
            return;
        }
        
        // Draw the circle
        StdDraw.circle(xCenter, yCenter, radius);
        
        // Recursive calls for three smaller circles
        circlesUponCircles(xCenter - radius / 1, yCenter, radius / 3, radiusMinimumDrawingThreshold);
        circlesUponCircles(xCenter + radius / 1, yCenter, radius / 3, radiusMinimumDrawingThreshold);
        circlesUponCircles(xCenter, yCenter + radius / 1, radius / 3, radiusMinimumDrawingThreshold);
        circlesUponCircles(xCenter, yCenter - radius / 1, radius / 3, radiusMinimumDrawingThreshold);
    }

    /**
     * This method uses recursion to create a reverse of the given array
     * 
     * @param array the array to create a reverse of, not to be mutated
     * @return an array with the same data as the input but in reverse order
     */
    public static int[] toReversed(int[] array) {
        int[] reversed = new int[array.length];
        reverseHelper(array, reversed, 0, array.length - 1);
        return reversed;
    }

    // Helper method for recursive array reversal
    private static void reverseHelper(int[] array, int[] reversed, int start, int end) {
        // Base case: if start index is greater than end, stop recursion
        if (start > end) {
            return;
        }
        // Swap elements
        reversed[start] = array[end];
        reversed[end] = array[start];
        // Recursive call for next indices
        reverseHelper(array, reversed, start + 1, end - 1);
    }
    
    /**
     * This method uses recursion to compute the greatest common divisor
     * for the two input values
     * 
     * @param p first operand
     * @param q second operand
     * @return greatest common divisor of p and q
     */
    public static int gcd(int p, int q) {
        // Base case: if q is 0, return p
        if (q == 0) {
            return p;
        }
        // Recursive call: gcd(q, p % q)
        return gcd(q, p % q);
    }
}

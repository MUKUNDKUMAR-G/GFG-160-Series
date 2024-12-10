/*
Input:

Enter the number of intervals: 4
Enter the intervals (start and end) one by one:
Interval 1: 1 2
Interval 2: 2 3
Interval 3: 3 4
Interval 4: 1 3

Output:

Minimum number of intervals to remove: 1 
 */

import java.util.*;

class Solution {
    static int minRemoval(int intervals[][]) {
        // Step 1: Sort intervals by their ending times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int lastEnd = Integer.MIN_VALUE; // Track the end of the last non-overlapping interval
        int removals = 0;

        // Step 2: Iterate through the intervals
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                // No overlap, update lastEnd
                lastEnd = interval[1];
            } else {
                // Overlap detected, increment removals
                removals++;
            }
        }

        return removals;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of intervals
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        // Read intervals from the user
        int[][] intervals = new int[n][2];
        System.out.println("Enter the intervals (start and end) one by one:");
        for (int i = 0; i < n; i++) {
            System.out.print("Interval " + (i + 1) + ": ");
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        // Calculate and display the result
        int result = minRemoval(intervals);
        System.out.println("Minimum number of intervals to remove: " + result);

        scanner.close();
    }
}

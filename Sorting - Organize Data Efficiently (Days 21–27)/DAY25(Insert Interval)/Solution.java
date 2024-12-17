/*
Input : 

Enter the number of intervals: 4
Enter intervals (start and end) one by one:
Interval 1: 1 3
Interval 2: 4 5
Interval 3: 6 7
Interval 4: 8 10
Enter the new interval (start and end): 5 6

Output:
Merged Intervals: [[1, 3], [4, 7], [8, 10]]
*/

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        int i = 0, n = intervals.length;

        //  Step 1: Add intervals before the new interval
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[] {newStart, newEnd});

        //  Step 3: Add intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of intervals
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        // Read intervals from the user
        int[][] intervals = new int[n][2];
        System.out.println("Enter intervals (start and end) one by one:");
        for (int i = 0; i < n; i++) {
            System.out.print("Interval " + (i + 1) + ": ");
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        // Read the new interval
        System.out.print("Enter the new interval (start and end): ");
        int[] newInterval = new int[2];
        newInterval[0] = scanner.nextInt();
        newInterval[1] = scanner.nextInt();

        // Process and print the result
        ArrayList<int[]> result = insertInterval(intervals, newInterval);
        System.out.println("Merged Intervals: " + toString(result));
    }

    // Helper function to print the list of intervals
    static String toString(ArrayList<int[]> intervals) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] interval : intervals) {
            sb.append("[").append(interval[0]).append(", ").append(interval[1]).append("], ");
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // Remove trailing comma and space
        sb.append("]");
        return sb.toString();
    }
}

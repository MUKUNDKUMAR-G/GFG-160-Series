import java.util.Scanner;

class Solution {
    public int circularSubarraySum(int[] arr) {
        int n = arr.length;
        int maxKadane = kadane(arr);

        // Calculate total sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Calculate minimum subarray sum
        int minSum = kadaneForMin(arr);

        // If all elements are negative, return the max subarray sum
        if (minSum == totalSum) {
            return maxKadane;
        }

        // Return the maximum of non-circular and circular subarray sums
        return Math.max(maxKadane, totalSum - minSum);
    }

    private int kadane(int[] arr) {
        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int num : arr) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    private int kadaneForMin(int[] arr) {
        int minEndingHere = 0, minSoFar = Integer.MAX_VALUE;
        for (int num : arr) {
            minEndingHere = Math.min(num, minEndingHere + num);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.circularSubarraySum(arr);

        System.out.println("The maximum circular subarray sum is: " + result);
    }
}

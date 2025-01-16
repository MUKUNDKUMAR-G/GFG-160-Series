import java.util.*;

class Solution {
    public int maxLen(int[] arr) {
        int n = arr.length;

        // Step 1: Replace 0s with -1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        // Step 2: Use HashMap for prefix sum
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // If prefixSum is 0, subarray from 0 to i has equal 0s and 1s
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefixSum is seen before, calculate the length of subarray
            if (prefixSumMap.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum));
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array (0s and 1s only):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.maxLen(arr);
        System.out.println("Length of the longest subarray with equal 0s and 1s: " + result);

        scanner.close();
    }
}
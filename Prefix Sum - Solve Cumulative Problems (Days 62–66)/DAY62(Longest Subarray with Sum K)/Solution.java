import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }
            if (prefixSumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum - k));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum (k): ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.longestSubarray(arr, k);
        System.out.println("Length of the longest subarray with sum k: " + result);

        scanner.close();
    }
}
import java.util.*;

class Solution {
    public int countSubarrays(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, prefixSum = 0;

        map.put(0, 1);

        for (int num : arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
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

        System.out.print("Enter the target sum: ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.countSubarrays(arr, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);

        scanner.close();
    }
}
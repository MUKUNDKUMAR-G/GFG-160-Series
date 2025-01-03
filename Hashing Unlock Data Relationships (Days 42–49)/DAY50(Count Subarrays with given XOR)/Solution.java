import java.util.*;

class Solution {
    public long subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        long count = 0;

        map.put(0, 1);
        for (int num : arr) {
            prefixXor ^= num;

            int requiredXor = prefixXor ^ k;
            if (map.containsKey(requiredXor)) {
                count += map.get(requiredXor);
            }
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
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
        System.out.print("Enter the target XOR value: ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        long result = solution.subarrayXor(arr, k);
        System.out.println("Number of subarrays with XOR " + k + ": " + result);

        scanner.close();
    }
}
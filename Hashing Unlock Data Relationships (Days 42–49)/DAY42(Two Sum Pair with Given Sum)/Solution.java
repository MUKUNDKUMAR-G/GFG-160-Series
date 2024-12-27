import java.util.HashMap;
import java.util.Scanner;

class Solution {

    // Function to determine if a pair with the given sum exists
    public boolean twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return true; // Pair found
            }
            map.put(arr[i], i);
        }

        return false; // No pair found
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
        int target = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.twoSum(arr, target);
        
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        scanner.close();
    }
}

import java.util.*;

class Solution {
    public int countPairs(int[] arr, int target) {
        int count = 0;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                count++;

                int tempLeft = left + 1;
                while (tempLeft < right && arr[tempLeft] == arr[left]) {
                    count++;
                    tempLeft++;
                }

                right--;
            } else if (sum < target) {
                left++; 
            } else {
                right--; 
            }
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
        int target = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.countPairs(arr, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);

        scanner.close();
    }
}

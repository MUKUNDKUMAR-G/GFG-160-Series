import java.util.Arrays;

class Solution {
    public int countPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum < target) {
                count += (j - i);
                i++; 
            } else {
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {7, 2, 5, 3};
        int target1 = 8;
        System.out.println("Count of pairs: " + solution.countPairs(arr1, target1)); // Output: 2

        int[] arr2 = {5, 2, 3, 2, 4, 1};
        int target2 = 5;
        System.out.println("Count of pairs: " + solution.countPairs(arr2, target2)); // Output: 4

        int[] arr3 = {2, 1, 8, 3, 4, 7, 6, 5};
        int target3 = 7;
        System.out.println("Count of pairs: " + solution.countPairs(arr3, target3)); // Output: 6
    }
}
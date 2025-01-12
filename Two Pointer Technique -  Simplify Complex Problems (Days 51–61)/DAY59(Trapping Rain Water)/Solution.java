import java.util.Scanner;

class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; 

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    totalWater += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    totalWater += rightMax - arr[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the heights of the blocks:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.maxWater(arr);
        System.out.println("Total water trapped: " + result);

        scanner.close();
    }
}
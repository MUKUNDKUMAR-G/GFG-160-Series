import java.util.Scanner;

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProduct = arr[0];
        int currMax = arr[0], currMin = arr[0];

        for (int i = 1; i < n; i++) {
            int tempMax = currMax;
            currMax = Math.max(arr[i], Math.max(currMax * arr[i], currMin * arr[i]));
            currMin = Math.min(arr[i], Math.min(tempMax * arr[i], currMin * arr[i]));
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
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
        int result = solution.maxProduct(arr);

        System.out.println("The maximum product subarray is: " + result);
    }
}

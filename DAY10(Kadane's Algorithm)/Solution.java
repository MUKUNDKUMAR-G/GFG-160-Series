import java.util.Scanner;

class Solution {
    public static int maxSubarraySum(int[] arr) {
        int sum = 0, maxSum = arr[0];
        
        for (int num : arr) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maxSubarraySum(arr);
        System.out.println("Maximum sum of contiguous subarray: " + result);
    }
}

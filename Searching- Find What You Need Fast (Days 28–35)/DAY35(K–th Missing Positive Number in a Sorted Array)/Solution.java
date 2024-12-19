import java.util.Scanner;

class Solution {

    public int kthMissing(int[] arr, int k) {
        // int n = arr.length;
    
        // int highestNumber = arr[n - 1];
        // int i = 0;
        // int count = 0;

        // for(int j = 0; i < highestNumber && i < n; i++,j++){
        //     if(arr[i] == j + 1){
        //         continue;
        //     } else{
        //         while(arr[i] != j+1){
        //             count++;
        //             if(count == k){
        //                 return j+1;
        //             }
    
        //             j++;
        //         }
        //     }
        // }
    
        // return count != 0 && count == k? count : (arr[n - 1] + k) - count;


        int low = 0, high = arr.length - 1;

        // Binary search for the position of the k-th missing number
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate the number of missing numbers up to arr[mid]
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        // Calculate the k-th missing number
        return k + high + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Create an instance of the solution class
        Solution solution = new Solution();
        int result = solution.kthMissing(arr, k);

        // Output the result
        System.out.println("The " + k + "-th missing positive number is: " + result);

        scanner.close();
    }
}

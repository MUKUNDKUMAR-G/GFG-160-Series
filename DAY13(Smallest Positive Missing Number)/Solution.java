import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the function to find the missing number
        int missing = missingNumber(arr);
        System.out.println("The smallest positive missing number is: " + missing);
    }

    public static int missingNumber(int[] arr) {
        // //Approach One - using Sorting method

        // int n = arr.length;
        // int count = 1;
        // Arrays.sort(arr);

        // for(int num : arr){
        //     if(num == count){
        //         count++;
        //     }
        // }

        // return count;

        //Approch Two - using hashing Technique
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        // Mark the presence of elements in the array
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the smallest missing positive number
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }
}

import java.util.Scanner;

public class Solution {
    private static void pushZerosToEnd(int arr[]) {
        int n = arr.length;
        int j = 0; // Index for non-zero elements
        
        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Size of an array:");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("\nEnter the Elements to an array with the size " + n);
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        
        System.out.println("\nBefore: The array before pushing the Zeros to the end");
        for(int i : arr){
            System.out.printf("%-5d", i);
        }

        pushZerosToEnd(arr);

        System.out.println("\nAfter: The array After pushed the Zeros to the end");
        for(int i : arr){
            System.out.printf("%-5d", i);
        }
    }
}

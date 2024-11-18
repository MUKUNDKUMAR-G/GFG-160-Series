import java.util.Scanner;
import java.util.Arrays;


public class Solution{
    //Function to rotate a array with the given position of rotation
    private static void rotateArr(int[] arr, int d){
        int n = arr.length;

        d = d % n;

        //Reverse the first d elements.
        reverseArr(arr, 0, d - 1);

        //Reverse the last n - d elements.
        reverseArr(arr, d, n - 1);

        //Reverse the entire array.
        reverseArr(arr, 0, n - 1);
    }

    //Function to reverse a array
    private static void reverseArr(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("\nEnter the number of positions to rotate: ");
        int d = input.nextInt();

        rotateArr(arr,d);

        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }
}
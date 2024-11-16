import java.util.Scanner;

public class Solution{

    private static int print2largest(int arr[]) {
        int n = arr.length;
        // If there are less than 2 elements, return -1
        if (n < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                // Update secondLargest before updating largest
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < /*!= */ largest) {
                // Update secondLargest if it's less than the current element
                secondLargest = arr[i];
            }
        }

        // If secondLargest remains unchanged, return -1
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
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

        System.out.println("Second Largest Element is :" + print2largest(arr));
    }
}
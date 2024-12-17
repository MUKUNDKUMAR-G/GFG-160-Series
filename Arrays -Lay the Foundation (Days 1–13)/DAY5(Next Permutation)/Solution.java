import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
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

        nextPermutation(arr);

        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the pivot (rightmost element where nums[i] < nums[i+1])
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            // The array is in descending order; reverse it for the smallest permutation
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the successor (smallest number greater than nums[pivot])
        int successor = -1;
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                successor = i;
                break;
            }
        }

        // Step 3: Swap the pivot and successor
        swap(nums, pivot, successor);

        // Step 4: Reverse the suffix (elements to the right of the pivot)
        reverse(nums, pivot + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

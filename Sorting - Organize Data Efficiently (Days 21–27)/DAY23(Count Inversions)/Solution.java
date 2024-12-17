import java.util.Scanner;

public class CountInversions {

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int invCount = 0;

        int i = left;   // Left subarray index
        int j = mid + 1; // Right subarray index

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                invCount += (mid - i + 1); // Count inversions
                // Rotate the element
                int temp = arr[j];
                for (int k = j; k > i; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[i] = temp;
                i++; mid++; j++;
            }
        }

        return invCount;
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            invCount += mergeSortAndCount(arr, left, mid);
            invCount += mergeSortAndCount(arr, mid + 1, right);

            invCount += mergeAndCount(arr, left, mid, right);
        }
        return invCount;
    }

    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int inversionCount = countInversions(arr);
        System.out.println("Number of inversions: " + inversionCount);
    }
}

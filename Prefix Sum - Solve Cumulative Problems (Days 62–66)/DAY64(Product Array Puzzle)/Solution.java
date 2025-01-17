import java.util.*;

class Solution {
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];

        // Step 1: Calculate prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= arr[i];
        }

        // Step 2: Calculate suffix products and combine with prefix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = productExceptSelf(arr);

        System.out.println("Product array:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        scanner.close();
    }
}
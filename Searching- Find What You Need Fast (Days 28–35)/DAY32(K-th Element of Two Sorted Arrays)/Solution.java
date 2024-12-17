import java.util.Scanner;

class Solution {

    public int kthElement(int[] a, int[] b, int k) {
        int low1 = 0, low2 = 0;
        int n1 = a.length, n2 = b.length;

        int kCount = 0;

        // Use two pointers to traverse both arrays
        while (low1 < n1 && low2 < n2) {
            if (a[low1] < b[low2]) {
                kCount++;
                if (kCount == k) {
                    return a[low1];
                }
                low1++;
            } else {
                kCount++;
                if (kCount == k) {
                    return b[low2];
                }
                low2++;
            }
        }

        // Traverse remaining elements in a[]
        while (low1 < n1) {
            kCount++;
            if (kCount == k) {
                return a[low1];
            }
            low1++;
        }

        // Traverse remaining elements in b[]
        while (low2 < n2) {
            kCount++;
            if (kCount == k) {
                return b[low2];
            }
            low2++;
        }

        return -1; // Should never reach here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array a: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the size of array b: ");
        int n2 = scanner.nextInt();

        int[] a = new int[n1];
        int[] b = new int[n2];

        System.out.println("Enter elements of array a (sorted): ");
        for (int i = 0; i < n1; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println("Enter elements of array b (sorted): ");
        for (int i = 0; i < n2; i++) {
            b[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Find and print the k-th element
        Solution solution = new Solution();
        int result = solution.kthElement(a, b, k);

        System.out.println("The " + k + "-th element in the combined sorted array is: " + result);

        scanner.close();
    }
}

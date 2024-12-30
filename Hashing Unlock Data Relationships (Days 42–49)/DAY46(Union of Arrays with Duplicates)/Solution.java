import java.util.*;

class Solution {
    public static int findUnion(int[] a, int[] b) {
        // Create a HashSet to store unique elements
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements of array a to the HashSet
        for (int num : a) {
            unionSet.add(num);
        }

        // Add all elements of array b to the HashSet
        for (int num : b) {
            unionSet.add(num);
        }

        // Return the size of the HashSet
        return unionSet.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array a: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of array a:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of array b: ");
        int m = scanner.nextInt();
        int[] b = new int[m];
        System.out.println("Enter the elements of array b:");
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        int unionCount = findUnion(a, b);
        System.out.println("Number of elements in the union: " + unionCount);

        scanner.close();
    }
}
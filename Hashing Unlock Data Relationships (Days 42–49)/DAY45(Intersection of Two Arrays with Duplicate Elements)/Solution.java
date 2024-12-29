import java.util.*;

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : b) {
            if (setA.contains(num)) {
                result.add(num);
                setA.remove(num); 
            }
        }

        return result;
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

        Solution solution = new Solution();
        ArrayList<Integer> intersection = solution.intersectionWithDuplicates(a, b);
        
        Collections.sort(intersection);
        System.out.println("Intersection of the two arrays:");
        System.out.println(intersection);

        scanner.close();
    }
}

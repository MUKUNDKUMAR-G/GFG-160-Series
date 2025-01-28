import java.util.*;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);  // Ensure lexicographical order
        backtrack(arr, 0, result);
        return result;
    }

    private void backtrack(char[] arr, int index, ArrayList<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        HashSet<Character> swapped = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (swapped.contains(arr[i])) continue;  // Avoid duplicate swaps at the same depth
            swapped.add(arr[i]);

            swap(arr, index, i);      // Swap to fix one character
            backtrack(arr, index + 1, result); // Recurse for next index
            swap(arr, index, i);      // Backtrack (undo swap)
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public class Solution {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String s = scanner.next();
            Solution sol = new Solution();
            ArrayList<String> permutations = sol.findPermutation(s);
            System.out.println("All unique permutations: " + permutations);
        }
    }
}
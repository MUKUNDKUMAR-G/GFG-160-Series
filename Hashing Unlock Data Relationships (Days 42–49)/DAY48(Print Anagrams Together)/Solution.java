import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] arr = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }

        Solution solution = new Solution();
        ArrayList<ArrayList<String>> result = solution.anagrams(arr);

        System.out.println("Grouped Anagrams:");
        for (ArrayList<String> group : result) {
            Collections.sort(group); 
            System.out.println(group);
        }

        scanner.close();
    }
}
class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        if (n == 0) return 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        Solution solution = new Solution();
        int result = solution.longestUniqueSubstr(s);
        System.out.println("Length of the longest substring with all distinct characters: " + result);

        scanner.close();
    }
}
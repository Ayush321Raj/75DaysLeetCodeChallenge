class Solution {

    public String longestCommonPrefix(String[] strs) {

        // Edge case
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take first string
        String first = strs[0];

        // Traverse each character
        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            // Compare with all strings
            for (int j = 1; j < strs.length; j++) {

                // Out of bounds OR mismatch
                if (i >= strs[j].length() ||
                    strs[j].charAt(i) != ch) {

                    return first.substring(0, i);
                }
            }
        }

        // Entire first string is common
        return first;
    }
}
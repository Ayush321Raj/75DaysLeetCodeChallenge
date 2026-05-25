class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frequency map for t
        for (char c : t.toCharArray()) {

            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int needCount = need.size();

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            // Valid frequency matched
            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue()) {

                have++;
            }

            // Shrink window
            while (have == needCount) {

                // Update answer
                if ((right - left + 1) < minLen) {

                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                // Window becomes invalid
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {

                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
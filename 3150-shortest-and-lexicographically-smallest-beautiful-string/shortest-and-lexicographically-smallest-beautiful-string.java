class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // Window me exactly k ones hone chahiye
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Exactly k ones mil gaye
            if (ones == k) {

                // Left side ke extra zeroes hatao
                while (s.charAt(left) == '0') {
                    left++;
                }

                int len = right - left + 1;
                String current = s.substring(left, right + 1);

                // Shorter string preferred
                // Same length ho to lexicographically smaller
                if (len < minLen ||
                    (len == minLen && current.compareTo(ans) < 0)) {

                    minLen = len;
                    ans = current;
                }
            }
        }

        return ans;
    }
}
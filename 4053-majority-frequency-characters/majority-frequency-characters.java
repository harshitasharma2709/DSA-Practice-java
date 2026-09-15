class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int bestFreq = 0;
        int bestSize = 0;

        for (int freq = 1; freq <= s.length(); freq++) {
            int size = 0;

            for (int i = 0; i < 26; i++) {
                if (count[i] == freq) {
                    size++;
                }
            }

            if (size > bestSize || (size == bestSize && freq > bestFreq)) {
                bestSize = size;
                bestFreq = freq;
            }
        }

        String ans = "";

        for (int i = 0; i < 26; i++) {
            if (count[i] == bestFreq) {
                ans += (char)('a' + i);
            }
        }

        return ans;
    }
}
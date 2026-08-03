class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // Frequency of p
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            freqS[s.charAt(right) - 'a']++;

            // Window size exceeds p.length()
            if (right - left + 1 > p.length()) {
                freqS[s.charAt(left) - 'a']--;
                left++;
            }

            // Check if current window is an anagram
            if (Arrays.equals(freqP, freqS)) {
                ans.add(left);
            }
        }

        return ans;
    }
}
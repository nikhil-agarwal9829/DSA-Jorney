class Solution {

    public int beautySum(String s) {

        int ans = 0;

        for (int left = 0; left < s.length(); left++) {

            int[] freq = new int[26];

            for (int right = left; right < s.length(); right++) {

                freq[s.charAt(right) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int f : freq) {

                    if (f == 0)
                        continue;

                    max = Math.max(max, f);
                    min = Math.min(min, f);
                }

                ans += max - min;
            }
        }

        return ans;
    }
}
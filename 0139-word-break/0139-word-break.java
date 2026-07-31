// class Solution {

//     Boolean[] dp;

//     boolean solve(String s, int i, HashSet<String> set){

//         if(i == s.length())
//             return true;

//         if(dp[i] != null)
//             return dp[i];

//         for(int end = i; end < s.length(); end++){

//             String word = s.substring(i, end + 1);

//             if(set.contains(word)){

//                 if(solve(s, end + 1, set)){
//                     dp[i] = true;
//                     return true;
//                 }
//             }
//         }

//         dp[i] = false;
//         return false;
//     }

//     public boolean wordBreak(String s, List<String> wordDict) {

//         dp = new Boolean[s.length()];

//         HashSet<String> set = new HashSet<>(wordDict);

//         return solve(s, 0, set);
//     }
// }
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {

            for (int end = i; end < n; end++) {

                String word = s.substring(i, end + 1);

                    if (set.contains(word) && dp[end + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
// class Solution {

//     public List<String> validStrings(int n) {
//         List<String> ans = new ArrayList<>();
//         backtrack(n, new StringBuilder(), ans);
//         return ans;
//     }

//     private void backtrack(int n, StringBuilder sb, List<String> ans) {

//         if (sb.length() == n) {
//             ans.add(sb.toString());
//             return;
//         }

//         // Always place '1'
//         sb.append('1');
//         backtrack(n, sb, ans);
//         sb.deleteCharAt(sb.length() - 1);

//         // Place '0' only if previous character is not '0'
//         if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '0') {
//             sb.append('0');
//             backtrack(n, sb, ans);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//     }
// }
class Solution {

    public List<String> validStrings(int n) {

        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.offer("");

        while (!q.isEmpty()) {

            String curr = q.poll();

            if (curr.length() == n) {
                ans.add(curr);
                continue;
            }

            // Always add '1'
            q.offer(curr + "1");

            // Add '0' only if previous char is not '0'
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '0') {
                q.offer(curr + "0");
            }
        }

        return ans;
    }
}
class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();

        int j = -1;

        for (int i = 0; i < s.length(); i++) {

            if (j >= 0 && sb.charAt(j) == s.charAt(i)) {
                sb.deleteCharAt(j);
                j--;
            } else {
                sb.append(s.charAt(i));
                j++;
            }
        }

        return sb.toString();
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]", "");
        String s1 = new StringBuilder(s).reverse().toString();
        if(s.equals(s1))return true;
        return false;
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }
        
        if (capitals == n) {
            return true;
        }
        
        if (capitals == 0) {
            return true;
        }
        
        if (capitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
class Solution {
    public String firstPalindrome(String[] words) {
        // Loop through each word in the array
        for (String word : words) {
            
            // If the word is a palindrome, return it immediately
            if (isPalindrome(word)) {
                return word;
            }
        }
        
        // If no palindrome is found, return an empty string
        return "";
    }
    
    // Helper method to check if a single string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        // Use two pointers to compare characters from the outside in
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }
        
        return true; // All characters matched
    }
}
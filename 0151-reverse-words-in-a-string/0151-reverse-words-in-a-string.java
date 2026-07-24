class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int n=words.length;
        String a="";
        for(int i=n-1;i>0;i--){
            a+=words[i];
            a+=" "; 
        }
        
        a+=words[0];
        return a;

    }
}
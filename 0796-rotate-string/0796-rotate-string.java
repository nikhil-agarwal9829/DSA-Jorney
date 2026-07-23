class Solution {
    public boolean rotateString(String s, String goal) {
        int i=0;
        while(i<s.length()){
            if(s.equals(goal)){
                return true;
            }
            s = s.substring(1) + s.charAt(0);;
            i++;

        }
        return false;
        
    }
}
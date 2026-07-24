class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder(s);
        int k=0;
        for(int i=0;i<s.length()-2;i++){
            if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2)){
                sb.deleteCharAt(i-k);
                k+=1;

            }
        }
        return sb.toString();
        
    }
}
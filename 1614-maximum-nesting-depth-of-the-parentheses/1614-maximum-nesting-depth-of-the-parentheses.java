class Solution {
    public int maxDepth(String s) {
        int i=0;
        int count=0;
        int c1=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                count++;
                c1=Math.max(c1,count);

            }else if(s.charAt(i)==')'){
                count--;
            }
            i++;
            
        }
        return c1;

        
    }
}
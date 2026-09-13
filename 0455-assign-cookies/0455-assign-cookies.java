class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int c=0;
        while(i<g.length){
            if(g[i]<=s[j]){
                c++;
                i++;
                j++;

            }else if(g[i]>s[j]){
                j++;
            }
            if(j==s.length)break;
        }
        return c;
        
    }
}
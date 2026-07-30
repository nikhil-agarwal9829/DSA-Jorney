class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<9){
            return n;
        }else if(n>8 && n<17){
            return 8+(n-8)*2;
        }else if(n>16 && n<25){
            return 24+(n-16)*3;
        }else if(n==25){
            return 52;
        }else{
            return 56;
        }
        
    }
}
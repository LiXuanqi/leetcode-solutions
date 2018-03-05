class Solution {
    public int reverse(int x) {
        int result;     
        if(x<0){
            return 0-helper(Math.abs(x));
        } else {
            return helper(x);
        }     
    }
    private int helper(int x){
        long result = 0;
        while(((x/10)!=0)||((x%10)!=0)){
            int remainder = x % 10;
            result = result * 10 + remainder;  
            x = x / 10;
        }
        if ((result <= Math.pow(2,31))&&(result >= -Math.pow(2,31))){
            return (int)result;
        } else {
            return 0;    
        }
    }   
}
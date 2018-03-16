class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> temp = new HashSet();
        while(n!=1){
            if(temp.contains(n)){
                return false;
            }
            temp.add(n);
            n = helper(n);
        }
        return true;
    }
    private int helper(int num){
        int result = 0;
        while(num!=0){
            result = result + (int)Math.pow((num % 10), 2);
            num = num / 10;
        }
        return result;
    }
}
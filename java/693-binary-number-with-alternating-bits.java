class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag = n & 1;
        while (n != 0) {
            n = n >>> 1;
            if ((n & 1) == flag) {
                return false;
            } else {
                flag = n & 1;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isMonotonic(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int sign = 0; // 0 : equals, 1: up, -1: down
        if (A[start] == A[end]) {
            sign = 0;
        } else if (A[start] < A[end]) {
            sign = 1;
        } else {
            sign = -1;
        }
        for (int i = 1; i < A.length; i++) {
            if (sign == 0 && A[i] != A[i - 1]) {
                return false;
            }
            if ((A[i] - A[i - 1]) * sign < 0) {
                return false;
            }
        }
        return true;
    }
}
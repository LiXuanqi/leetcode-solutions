class Solution {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        // up
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        // down
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }
}
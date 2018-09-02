class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length <= 2) {
            return true;
        }
        int flag = Integer.compare(A[0], A[1]);
        for (int i = 1; i < A.length; i++) {
            int diff = Integer.compare(A[i - 1], A[i]);
            if (diff == 0) {
                continue;
            }
            if (flag == 0) {
                flag = diff;
                continue;
            }
            if (diff != flag) {
                return false;
            }
        }
        return true;
    }
}
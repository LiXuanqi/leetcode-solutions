class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            // find odd;
            while (left < right && A[left] % 2 == 0) {
                left++;
            }
            // find even;
            while (left < right && A[right] % 2 != 0) {
                right--;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }
}
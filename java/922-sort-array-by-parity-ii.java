class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int evenPointer = 0;
        int oddPointer = 1;
        int[] ans = new int[A.length];
        for (int num : A) {
            if (num % 2 == 0) {
                ans[evenPointer] = num;
                evenPointer += 2;
            } else {
                ans[oddPointer] = num;
                oddPointer += 2;
            }
        }
        return ans;
    }
}
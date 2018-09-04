class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int count = 1;
        int pointer = digits.length - 1;
        while (pointer >= 0) {
            int sum = digits[pointer] + count;
            if (sum >= 9) {
                count = sum / 10;
                digits[pointer] = sum % 10;
            } else {
                digits[pointer] = sum;
                count = 0;
            }
            pointer--;
        }
        if (count != 0) {
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newResult[i + 1] = digits[i]; 
            }
            return newResult;
        }
        return digits;  
    }
}
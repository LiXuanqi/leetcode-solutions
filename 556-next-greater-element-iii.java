class Solution {
    public int nextGreaterElement(int n) {
        if (n <= 0) {
            return -1;
        }
        String num = Integer.toString(n);
        // find drop position.
        int pointer = num.length() - 1;
        while (pointer >= 0) {
            if (pointer == 0) {
                return -1;
            }
            if (num.charAt(pointer - 1) < num.charAt(pointer)) {
                break;
            }
            pointer--;
        }
  
        int flag = pointer - 1;
        int largerThanFlagNumberIndex = findLarger(num, pointer, num.length() - 1, num.charAt(flag));
        // swap
        char[] input = num.toCharArray();
        char temp = input[flag];
        input[flag] = input[largerThanFlagNumberIndex];
        input[largerThanFlagNumberIndex] = temp;
        // reverse
        reverse(input, pointer, input.length - 1);
        try {
            return Integer.parseInt(new String(input));
        } catch (Exception e) {
            return -1;
        }

    }
    private int findLarger(String num, int left, int right, char target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num.charAt(mid) > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (num.charAt(right) > target) {
            return right;
        }
        if (num.charAt(left) > target) {
            return left;
        }
        return -1;
    }
    
    private void reverse(char[] input, int left, int right) {
        while (left < right) {
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++;
            right--;
        }
    }
    
}
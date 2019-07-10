class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return result;
        }
        int[] map = new int[26];
        // count the p.
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        // printArray(map);
        // init window.
        int left = 0;
        int right = -1;
        while (right < s.length() - 1) {
            if ((right - left + 1) < p.length()) {
                // move right
                right++;
                map[s.charAt(right) - 'a']--;
            
            } else {
                // move left and right
                right++;
                map[s.charAt(right) - 'a']--;
                map[s.charAt(left) - 'a']++;
                left++;
            }
            // printArray(map);
            if (isMapValid(map)) {
                result.add(left);
            }
        }
        return result;
    }
    private boolean isMapValid(int[] map) {
        for (int num : map) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num);
            System.out.print(' ');
        }
        System.out.println();
    }
}

// note:
// 1. start index of right.
// 2. the meaning of left and right.
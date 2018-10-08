class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        int[] map = new int[26];
    
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
       
        }
        
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            // move right.
            map[s2.charAt(right) - 'a']--;
            right++;
            if (right - left > s1.length()) {
                // delete left.
                map[s2.charAt(left) - 'a']++;
                left++;
            }
            if (isMapZeros(map)) {
                return true;
            }
        }
        return false;
    }
    private boolean isMapZeros(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
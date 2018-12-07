class Solution {
    int maxLength = 0;
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // why map.get(c) >= left? Not move back.
            if (map.containsKey(c) && map.get(c) >= left) {
                // move left.
                left = map.get(c) + 1;
            }
            map.put(c, right);
            int length = right - left + 1; 
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // move left.
                left = Math.max(map.get(s.charAt(right)) + 1, left); // left never move back.
            } 
            map.put(s.charAt(right), right);
            int length = right - left + 1;
            ans = Math.max(length, ans);
        }
        return ans;
    }
}
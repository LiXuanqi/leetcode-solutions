class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int slow = 0;
        int fast = 0;
        int matchCount = 0;
        String result = "";
        int minLength = Integer.MAX_VALUE;
        while (fast < s.length()) {
            // find right position.
            while (matchCount != map.size() && fast < s.length()) {
                if (map.containsKey(s.charAt(fast))) {
                    map.put(s.charAt(fast), map.get(s.charAt(fast)) - 1);
                    if (map.get(s.charAt(fast)) == 0) {
                        matchCount++;
                    }
                }
                fast++;  
            }
            while (matchCount == map.size() && slow <= fast) {
                // check min length.
                if (fast - slow < minLength) {
                    minLength = fast - slow;
                    result = s.substring(slow, fast);
                }
                // move left;
                if (map.containsKey(s.charAt(slow))) {
                    map.put(s.charAt(slow), map.get(s.charAt(slow)) + 1);
                    if (map.get(s.charAt(slow)) > 0) {
                        matchCount--;
                    }
                }
                slow++;
            }
        }
        return result;
    }
}
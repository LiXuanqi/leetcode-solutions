class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            if (map.get(s.charAt(i)) == 1) {
                map.put(s.charAt(i), 0);
                count = count + 2;
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (map.containsValue(1)) {
            count++;
        }
        return count;     
    }
}

// NOTE:
// 1. SET
// 2. Greedy
class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (stack.isEmpty() || stack.peekFirst() != map.get(character)) {
                stack.offerFirst(character);
            } else {
                stack.pollFirst();
            }
        }
        return stack.size() == 0;
    }
}

// Time = O(n)
// Space = O(n)
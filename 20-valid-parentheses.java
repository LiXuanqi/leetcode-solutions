class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == '}' || c == ']') {
                if (map.get(c) != stack.pollFirst()) {
                    return false;
                }
            } else {
                stack.offerFirst(c);
            }
        }
        return stack.isEmpty(); // All parentheses should be matched.
    }
}
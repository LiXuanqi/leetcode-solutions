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
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.offerFirst(c);
            } else {
                if (stack.peekFirst() != map.get(c)) {
                    return false;
                } else {
                    stack.pollFirst();
                }
            }
        }
        return stack.isEmpty();
    }
}
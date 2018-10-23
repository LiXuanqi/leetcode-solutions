class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new LinkedList<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (map.containsKey(c)) {
                stack.offerFirst(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(stack.peekFirst()) == c) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
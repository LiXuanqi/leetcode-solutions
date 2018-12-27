class Solution {
    public String simplifyPath(String path) {
        String[] commands = path.split("/+");
        Deque<String> stack = new LinkedList<>();
        for (String command : commands) {
            if (command.equals("")) {
                continue;
            } else if (command.equals(".")) {
                continue;
            } else if (command.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            } else {
                stack.offerFirst(command);
            }
        }
        
        return stackToPath(stack);
    }
    private String stackToPath(Deque<String> stack) {
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(stack.pollLast());     
        }
        return sb.toString();
    }
}
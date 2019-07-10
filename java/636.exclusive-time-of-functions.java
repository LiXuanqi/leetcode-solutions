class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n < 1 || logs == null) {
            return null;
        }
        int[] result = new int[n];
        // print(result);
        int prev = 0;
        int curr = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String log : logs) {
            String[] cmds = log.split(":");
            int id = Integer.parseInt(cmds[0]);
            String action = cmds[1];
            int endTime = Integer.parseInt(cmds[2]);
            // handler log
            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peekFirst()] += endTime - prev;
                    prev = endTime;
                }
                stack.offerFirst(id);
            } else {
                result[stack.pollFirst()] += endTime - prev + 1;
                prev = endTime + 1;
            }
            // print(result);
        }
        return result;
    }
}
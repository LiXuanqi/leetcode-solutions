class Solution {
    private final int[] directionX = {0, 0, 1, -1};
    private final int[] directionY = {1, -1, 0, 0};
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Boolean> prefixIsWord = getPrefixIsWord(words);
        // System.out.println(prefixIsWord);
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
              
                used[i][j] = true;
                dfs(board, board[i][j] + "", used, i, j, result, prefixIsWord);
                used[i][j] = false;
                
            }
        }
        return new ArrayList<>(result);
    }
    private void dfs(
        char[][] board,
        String prefix,
        boolean[][] used,
        int x,
        int y,
        Set<String> result,
        Map<String, Boolean> prefixIsWord
    ) {
        if (!prefixIsWord.containsKey(prefix)) {
            return;
        }
        if (prefixIsWord.get(prefix)) {
            result.add(prefix);
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];
            if (!isValid(nextX, nextY, board) || used[nextX][nextY]) {
                continue;
            }
            used[nextX][nextY] = true;
            dfs(board, prefix + board[nextX][nextY], used, nextX, nextY, result, prefixIsWord);
            used[nextX][nextY] = false;
        }
    }
    private Map<String, Boolean> getPrefixIsWord(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                map.put(prefix, map.getOrDefault(prefix, false) || i == word.length());
            }
        }
        return map;
    }
    private boolean isValid(int x, int y, char[][] board) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
}
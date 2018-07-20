class Solution {
  public List<List<String>> solveNQueens(int n) {
      List<List<Integer>> result = new ArrayList<>();
      dfs(new boolean[n], new ArrayList<Integer>(), result); 
      return draw(result, n);
  }
  private void dfs(boolean[] used, List<Integer> temp, List<List<Integer>> solutions) {
      if (temp.size() == used.length) {
          solutions.add(new ArrayList<Integer>(temp));
          return;
      }
      for (int i = 0; i < used.length; i++) {
          if (used[i] == true) {
              continue;
          }
          temp.add(i);
          used[i] = true;
          if (isValid(temp, temp.size() - 1)) {
              dfs(used, temp, solutions);   
          }
          temp.remove(temp.size() - 1);
          used[i] = false;
      }
  }
  private boolean isValid(List<Integer> temp, int index) {
      for (int i = 0; i < temp.size(); i++) {
          if (index == i) {
              continue;
          }
          if ((temp.get(i) - temp.get(index) == i - index) || (temp.get(i) - temp.get(index) == index - i)) {
              return false;
          }
      }
      return true;
  }
  private List<List<String>> draw(List<List<Integer>> solutions, int n) {
      List<List<String>> results = new ArrayList<>();
      char[] dot = new char[n];
      for (int i = 0; i < dot.length; i++) {
          dot[i] = '.';
      }
      for (List<Integer> solution : solutions) {
          List<String> result = new ArrayList<>();
          for (int pos : solution) {
              dot[pos] = 'Q';
              result.add(new String(dot));
              dot[pos] = '.';
          }
          results.add(result);
      }
      return results;
  }
}

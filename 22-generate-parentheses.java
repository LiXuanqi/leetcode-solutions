class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      if (n == 0) {
          result.add("");
          return result;
      }   
      dfs(n, 0, 0, new StringBuilder(), result);
      return result;
  }
  private void dfs(int n, int left, int right, StringBuilder temp, List<String> solutions) {
      if (left + right == 2 * n) {
          solutions.add(temp.toString());
          return;
      }
      if (left < n) {         
          temp.append('(');
          dfs(n, left + 1, right, temp, solutions);
          temp.deleteCharAt(temp.length() - 1);
      }
      if (right < left) {
          temp.append(')');
          dfs(n, left, right + 1, temp, solutions);
          temp.deleteCharAt(temp.length() - 1);
      }     
  }
}

// Space = O(2n)
// Time = O(2^(2n))
class Solution {
  public List<String> letterCasePermutation(String S) {
      List<String> solutions = new ArrayList<>();
      dfs(new StringBuilder(S), 0, solutions);
      return solutions;
  }
  private void dfs(StringBuilder sb, int index, List<String> solutions) {
      if (index == sb.length()) {
          solutions.add(sb.toString());
          return;
      }
      System.out.println(Character.isAlphabetic(sb.charAt(index)));
      if (Character.isAlphabetic(sb.charAt(index))) {
          sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));
          dfs(sb, index + 1, solutions);
  
          sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));     
          dfs(sb, index + 1, solutions);
      } else {
          dfs(sb, index + 1, solutions);
      }
      
      
     
  }
}
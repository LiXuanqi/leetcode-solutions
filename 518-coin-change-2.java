class Solution {
  private int result = 0;
  public int change(int amount, int[] coins) {
      if (amount == 0 && coins.length == 0) {
          return 1;
      }
      if (amount != 0 && coins.length == 0) {
          return 0;
      }
      dfs(amount, coins, 0);
      return result;
  }
  private void dfs(int amount, int[] coins, int level) {
      if (amount == 0) {
          result += 1;
          return;
      }
      if (amount < 0 || level >= coins.length) {
          return;
      }
      for (int i = 0; i <= amount / coins[level]; i++) {
          dfs(amount - coins[level] * i, coins, level + 1);
      }
  }
}
// 0 [] => 1
// 7 [] => 0

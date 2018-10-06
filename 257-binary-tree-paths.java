/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        List<List<Integer>> solutions = new ArrayList<>();
        if (root == null) {
            return results;
        }
        dfs(root, new ArrayList<>(), solutions);
        for (List<Integer> solution : solutions) {
            StringBuilder sb = new StringBuilder();
            for (int num : solution) {
                sb.append(num);
                sb.append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            results.add(sb.toString());
        }
        return results;
    }
    private void dfs(TreeNode root, List<Integer> temp, List<List<Integer>> solutions) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            solutions.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        dfs(root.left, temp, solutions);
        dfs(root.right, temp, solutions);
        temp.remove(temp.size() - 1);
    }
}
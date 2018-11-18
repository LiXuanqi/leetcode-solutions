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
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        getHeight(root, map);
  
        for (int i = low; i <= high; i++) {
            if (map.containsKey(i)) {
                ans.add(map.get(i));
            }
        }
        return ans;
    }
    private int getHeight(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left, map);
        int right = getHeight(node.right, map);
        int height = Math.max(left, right) + 1;
        if (!map.containsKey(height)) {
            map.put(height, new ArrayList<>());
        }
        map.get(height).add(node.val);
        low = Math.min(low, height);
        high = Math.max(high, height);
        return height;
    }
}
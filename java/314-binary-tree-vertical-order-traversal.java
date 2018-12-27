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
    class MyTreeNode {
        TreeNode node;
        int position;
        public MyTreeNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
            
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int leftRange = 0;
        int rightRange = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(new MyTreeNode(root, 0));
        while (!queue.isEmpty()) {
            MyTreeNode node = queue.poll();
            if (!map.containsKey(node.position)) {
                map.put(node.position, new ArrayList<>());
            }
            if (node.position < leftRange) {
                leftRange = node.position;
            }
            if (node.position > rightRange) {
                rightRange = node.position;
            }

            map.get(node.position).add(node.node.val);
            if (node.node.left != null) {
                queue.offer(new MyTreeNode(node.node.left, node.position - 1));
            }
            if (node.node.right != null) {
                queue.offer(new MyTreeNode(node.node.right, node.position + 1));
            }
        }
        
        for (int i = leftRange; i <= rightRange; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
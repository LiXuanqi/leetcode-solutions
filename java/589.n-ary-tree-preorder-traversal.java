/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pollFirst();
            ans.add(curr.val);
            Collections.reverse(curr.children);
            for (Node next : curr.children) {
                stack.offerFirst(next);
            }
        }
        return ans;
    }
}
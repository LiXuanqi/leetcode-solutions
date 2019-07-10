/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if (node == null) {
          return null;
      }
      return clone(node, new HashMap<>());
  }
  private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
      if (node == null) {
          return null;
      }
      if (map.containsKey(node)) {
          return map.get(node);
      }
      UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
      map.put(node, copyNode);
      for (UndirectedGraphNode neighbor : node.neighbors) {
          copyNode.neighbors.add(clone(neighbor, map));
      }
      return copyNode;
  }
}
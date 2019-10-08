class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Edge>> graph = buildGraph(flights);
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.distance, n2.distance);
        });
        pq.offer(new Node(src, 0, -1));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.level > K) {
                continue;
            }
            if (curr.val == dst) {
                return curr.distance;
            }
            // expand
            if (graph.containsKey(curr.val)) {
                for (Edge edge : graph.get(curr.val)) {
                    pq.offer(new Node(edge.to, curr.distance + edge.cost, curr.level + 1));
                }
            } 
        }
        return -1;
    }
    private Map<Integer, List<Edge>> buildGraph(int[][] flights) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new Edge(to, cost));
        }
        return map;
    }
    
}

class Node {
    int val;
    int distance;
    int level;
    public Node(int val, int distance, int level) {
        this.val = val;
        this.distance = distance;
        this.level = level;
    }
}

class Edge {
    int to;
    int cost;
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
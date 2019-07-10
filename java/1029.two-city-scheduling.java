class Solution {
    class Cost {
        int A;
        int B;
        public Cost(int A, int B) {
            this.A = A;
            this.B = B;
        }
        public String toString() {
            return "(" + A + "," + B +")";
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        List<Cost> list = new ArrayList<>();
        for (int[] cost : costs) {
            list.add(new Cost(cost[0], cost[1]));
        }
        Collections.sort(list, (Cost cost1, Cost cost2) -> {
            return Integer.compare(Math.abs(cost2.A - cost2.B), Math.abs(cost1.A - cost1.B));
        });
        // System.out.println(list);
        int restA = costs.length / 2;
        int restB = costs.length / 2;
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            Cost cost = list.get(i);
            if (restA == 0) {
                ans += cost.B;
                restB--;
            } else if (restB == 0) {
               ans += cost.A;
                restA--;
            } else {
                if (cost.A < cost.B) {
                    ans += cost.A;
                    restA--;
                } else {
                    ans += cost.B;
                    restB--;
                }    
            }
        }
        return ans;
    }
}
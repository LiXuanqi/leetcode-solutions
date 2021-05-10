class Leaderboard {
    
    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;

    public Leaderboard() {
        this.scores = new HashMap<>();
        this.sortedScores = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!this.scores.containsKey(playerId)) {
            this.scores.put(playerId, score);
            this.sortedScores.put(score, this.sortedScores.getOrDefault(score, 0) + 1);
        } else {
            int preScore = this.scores.get(playerId);
            this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
            if (this.sortedScores.get(preScore) == 0) {
                this.sortedScores.remove(preScore);
            }
            
            int newScore = preScore + score;
            this.scores.put(playerId, preScore + score);
            this.sortedScores.put(newScore, this.sortedScores.getOrDefault(newScore, 0) + 1);
        }

    }
    
    public int top(int K) {
        int ans = 0;
        for (int key : this.sortedScores.keySet()) {
     
            
            int times = this.sortedScores.get(key);

            
            for (int i = 0; i < times; i++) {
                ans += key;
                K -= 1;
                if (K == 0) {
                    return ans;
                }
            }
        }
        return ans;    
    }
    
    public void reset(int playerId) {
        int preScore = this.scores.get(playerId);
        this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
        if (this.sortedScores.get(preScore) == 0) {
            this.sortedScores.remove(preScore);
        }
        this.scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */

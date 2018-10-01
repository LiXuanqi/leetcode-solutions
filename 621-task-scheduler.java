// ans = (n+1) * (k - 1) + p 
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] frequent = new int[26];
        int maxFrequence = Integer.MIN_VALUE;
        int frequenceTime = 0;
        for (char task : tasks) {
            frequent[task - 'A']++;
            if (frequent[task - 'A'] > maxFrequence) {
                maxFrequence = frequent[task - 'A'];
                frequenceTime = 0;
            }
            if (frequent[task - 'A'] == maxFrequence) {
                frequenceTime++;
            }
        }
        int ans = (n + 1) * (maxFrequence - 1) + frequenceTime;
        if (ans < tasks.length) {
            return tasks.length;
        }
        return ans;
    }
}
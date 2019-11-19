class Solution {
public:
    double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0;
        }
        // for passenger 1:
        // seat it's own seat
        double probability1 = 1.0 / n;
        // seat neigher his own nor nth
        double probability2 = ((n - 2.0) / n) * nthPersonGetsNthSeat(n - 1);
        return probability1 + probability2; 
    }
};
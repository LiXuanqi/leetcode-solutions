class MovingAverage {
    List<Integer> data;
    int sum;
    int size;
    int count;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.data = new LinkedList();
        this.sum = 0;
        this.size = size;
        this.count = 0;
    }
    
    public double next(int val) {
        if (count < size) {
            data.add(val);
            count++;
            sum += val;
        } else {
            int head = data.get(0);
            sum -= head;
            data.remove(0);
            data.add(val);
            sum += val;
        }
        return (double) sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
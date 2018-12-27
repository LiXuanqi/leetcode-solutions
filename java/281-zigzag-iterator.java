public class ZigzagIterator {
    int counter = 0;
    List<List<Integer>> lists;
    int[] indexs;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new ArrayList<>();
        lists.add(v1);
        lists.add(v2);
        indexs = new int[lists.size()];
    }

    public int next() {
        // find not empty.
        // System.out.println(counter);
        
        while (counter < lists.size() && lists.get(counter).size() <= indexs[counter]) {
            counter++;
            if (counter == lists.size()) {
                counter = 0;
            }
            // System.out.println(counter); 
        }

        List<Integer> list = lists.get(counter);
        int num = list.get(indexs[counter]++);
        
        counter = counter == lists.size() - 1 ? 0 : counter + 1;
        // System.out.println(num);
        return num;
        
    }

    public boolean hasNext() {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > indexs[i]) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
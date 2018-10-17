/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> data;
    int pointer;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.data = new ArrayList<>();
        dfs(nestedList);
        pointer = 0;
    }
    
    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                data.add(ni.getInteger());
            } else {
                dfs(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return data.get(pointer++);  
    }

    @Override
    public boolean hasNext() {
        return pointer <= data.size() - 1;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
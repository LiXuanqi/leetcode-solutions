public class Vector2D implements Iterator<Integer> {
    List<Integer> data;
    int pointer;
    public Vector2D(List<List<Integer>> vec2d) {
        pointer = 0;
        data = new ArrayList<>();
        for (int i = 0; i < vec2d.size(); i++) {
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                data.add(vec2d.get(i).get(j));
            }
        }
    }

    @Override
    public Integer next() {
        int val = data.get(pointer);
        pointer++;
        return val;
    }

    @Override
    public boolean hasNext() {
        return pointer < data.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
  public int getImportance(List<Employee> employees, int id) {
      Map<Integer, Employee> map = new HashMap<>();
      for (Employee employee : employees) {
          map.put(employee.id, employee);
      }
      int result = 0;
      Queue<Employee> queue = new LinkedList<>();
      queue.offer(map.get(id));
      while (!queue.isEmpty()) {
          Employee person = queue.poll();
          result += person.importance;
          for (int subordinate : person.subordinates) {
              queue.offer(map.get(subordinate));
          }
      }
      return result;
  }
}
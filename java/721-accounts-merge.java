class Solution {
    Map<Integer, Integer> father = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        Map<String, List<Integer>> emailToIds = getEmailToIds(accounts);
        for (String email : emailToIds.keySet()) {
            List<Integer> ids = emailToIds.get(email);
            for (int i = 0; i < ids.size() - 1; i++) {
                union(ids.get(i), ids.get(i + 1));
            }
        }
        // System.out.println(father);
        
        Map<Integer, Set<String>> idToEmails = getIdToEmails(accounts);
        List<List<String>> result = new ArrayList<>();
        for (int id : idToEmails.keySet()) {
            List<String> emails = new ArrayList<>(idToEmails.get(id));
            Collections.sort(emails);
            String username = accounts.get(id).get(0);
            emails.add(0, username);
            result.add(emails);
        }
        return result;
    }
    private Map<Integer, Set<String>> getIdToEmails(List<List<String>> accounts) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int id = 0; id < accounts.size(); id++) {
            int rootId = find(id);
            List<String> account = accounts.get(id);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!map.containsKey(rootId)) {
                    map.put(rootId, new HashSet<>());
                }
                map.get(rootId).add(email);
            }
        }
        return map;
    }
    private Map<String, List<Integer>> getEmailToIds(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int id = 0; id < accounts.size(); id++) {
            // init father
            father.put(id, id);
            List<String> account = accounts.get(id);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!map.containsKey(email)) {
                    map.put(email, new ArrayList<>());
                }
                map.get(email).add(id);
            }
        }
        return map;
    }
    private int find(int id) {
        List<Integer> path = new ArrayList<>();
        while (father.get(id) != id) {
            path.add(id);
            id = father.get(id);
        }
        for (int p : path) {
            father.put(p, id);
        }
        return id;
    }
    private void union(int id1, int id2) {
        int father1 = find(id1);
        int father2 = find(id2);
        if (father1 == father2) {
            return;
        }
        father.put(father1, father2);
    }
}
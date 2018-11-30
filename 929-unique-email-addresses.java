class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(formatEmail(email));
        }
        return set.size();
    }
    private String formatEmail(String email) {
        String[] names = email.split("@");
        String localName = names[0];
        String domainName = names[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localName.length(); i++) {
            if (localName.charAt(i) == '.') {
                continue;
            }
            if (localName.charAt(i) == '+') {
                break;
            }
            sb.append(localName.charAt(i));
        }
        sb.append("@");
        sb.append(domainName);
        return sb.toString();
    }
}
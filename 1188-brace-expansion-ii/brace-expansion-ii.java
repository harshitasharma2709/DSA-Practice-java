import java.util.*;

class Solution {

    String s;
    int pos;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        pos = 0;

        Set<String> set = solve();

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    Set<String> solve() {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (pos < s.length() && s.charAt(pos) != '}') {

            if (s.charAt(pos) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                pos++;
            } 
            else {
                Set<String> next;

                if (s.charAt(pos) == '{') {
                    pos++;
                    next = solve();
                    pos++;
                } 
                else {
                    next = new HashSet<>();
                    next.add("" + s.charAt(pos));
                    pos++;
                }

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : next) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }
        }

        result.addAll(current);

        return result;
    }
}
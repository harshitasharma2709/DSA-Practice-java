import java.util.*;

class Solution {

    class Pair {
        long score;
        List<Integer> ids;

        Pair(long score, List<Integer> ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    List<List<Integer>> a;
    Pair[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);

            List<Integer> temp = new ArrayList<>();
            temp.add(x.get(0));
            temp.add(x.get(1));
            temp.add(x.get(2));
            temp.add(i);

            a.add(temp);
        }

        a.sort((x, y) -> {
            if (!x.get(0).equals(y.get(0)))
                return Integer.compare(x.get(0), y.get(0));

            return Integer.compare(x.get(1), y.get(1));
        });

        dp = new Pair[n][5];

        Pair ans = solve(0, 4);

        int[] result = new int[ans.ids.size()];

        for (int i = 0; i < ans.ids.size(); i++) {
            result[i] = ans.ids.get(i);
        }

        return result;
    }

    Pair solve(int i, int k) {

        if (i == a.size() || k == 0) {
            return new Pair(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Skip
        Pair skip = solve(i + 1, k);

        // Take
        int end = a.get(i).get(1);
        int next = findNext(i + 1, end);

        Pair p = solve(next, k - 1);

        List<Integer> ids = new ArrayList<>(p.ids);
        ids.add(a.get(i).get(3));

        Collections.sort(ids);

        Pair take = new Pair(
            a.get(i).get(2) + p.score,
            ids
        );

        if (take.score > skip.score) {
            return dp[i][k] = take;
        }

        if (take.score < skip.score) {
            return dp[i][k] = skip;
        }

        if (small(take.ids, skip.ids)) {
            return dp[i][k] = take;
        }

        return dp[i][k] = skip;
    }

    int findNext(int start, int end) {

        int l = start;
        int r = a.size();

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (a.get(mid).get(0) > end) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    boolean small(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}
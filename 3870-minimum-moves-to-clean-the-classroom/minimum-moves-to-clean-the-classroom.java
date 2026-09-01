import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Find start and count litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;

        int totalMask = 1 << litterCount;
        int[][] litter = new int[litterCount][2];

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'L') {
                    litter[k][0] = i;
                    litter[k][1] = j;
                    k++;
                }
            }
        }

        // visited[row][col][mask][energy]
        boolean[][][][] visited =
            new boolean[m][n][totalMask][energy + 1];

        Queue<int[]> q = new LinkedList<>();

        // row, col, mask, remaining energy, moves
        q.add(new int[]{sr, sc, 0, energy, 0});
        visited[sr][sc][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int en = cur[3];
            int moves = cur[4];

            if (mask == totalMask - 1) {
                return moves;
            }

            if (en == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = en - 1;

                // Reset energy at R
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                int newMask = mask;

                // Check if litter is collected
                for (int i = 0; i < litterCount; i++) {
                    if (litter[i][0] == nr && litter[i][1] == nc) {
                        newMask = newMask | (1 << i);
                    }
                }

                if (!visited[nr][nc][newMask][newEnergy]) {

                    visited[nr][nc][newMask][newEnergy] = true;

                    q.add(new int[]{
                        nr, nc, newMask, newEnergy, moves + 1
                    });
                }
            }
        }

        return -1;
    }
}
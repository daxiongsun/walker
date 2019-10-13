package com.ngsky.walker.topcoder.SRM253;

/**
 * <dl>
 * <dt>ABCPath</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2019/10/10 下午10:56</dd>
 * </dl>
 *
 * @author ngsky
 */
public class ABCPath {

    int max = 0;
    int r = 0;
    int c = 0;
    String[] les;

    public int length(String[] les) {
        r = les.length;
        c = les[0].length();
        this.les=les;
        dfs(0,0,0,0);
        return max;
    }

    int[][] dir = {{0, 1}, {0, -1},
            {1, 0}, {-1, 0},
            {1, 1}, {1, -1},
            {-1, 1}, {-1, 0}};

    private void dfs(int x, int y, int cl, int lv) {
        // (x,y)->(cl)
        if (lv - (les[x].charAt(y) - 'a') == 1) {
            cl += 1;
            max = Math.max(max, cl);
            return;
        }

        for (int[] ints : dir) {
            int nx = x + ints[0];
            int ny = y + ints[1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                dfs(nx, ny, cl, les[x].charAt(y) - 'a');
            }
        }
    }
}

let dxy = [[0, 1], [1, 0], [0, -1], [-1, 0]];
/**
 * 最小体力消耗路径
 * @param heights
 * @returns {any}
 */
let minimumEffortPath = (heights) => {
    let col = heights.length;
    let row = heights[0].length;
    let minGrid = new Array(col).fill(0).map(() => new Array(row).fill(0x3f3f3f3f));
    let dfs = (x, y, d) => {
        if (d < minGrid[x][y]) {
            minGrid[x][y] = d;
            for (let xy of dxy) {
                let nx = x + xy[0];
                let ny = y + xy[1];
                if (nx < heights.length && ny < heights[0].length && nx >= 0 && ny >= 0) {
                    dfs(nx, ny, Math.max(d, Math.abs(heights[nx][ny] - heights[x][y])));
                }

            }
        }
    }
    dfs(0, 0, 0);
    return minGrid[minGrid.length - 1][minGrid[0].length - 1];
};

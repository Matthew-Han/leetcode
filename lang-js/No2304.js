let minGrid;
/**
 * 网格中的最小路径代价
 * @param grid
 * @param moveCost
 */
let minPathCost = (grid, moveCost) => {
    let ans = 0x3f3f3f3f;
    minGrid = new Array(grid.length).fill(0).map(() => new Array(grid[0].length).fill(0x3f3f3f3f));
    for (let i = 0; i < grid[0].length; i++) {
        dfs(grid, moveCost, 0, 0, i);
    }
    for (let i = 0; i < minGrid[minGrid.length - 1].length; i++) {
        ans = Math.min(ans, minGrid[minGrid.length - 1][i]);
    }
    return ans;
};

let dfs = (grid, moveCost, sum, x, y) => {
    if (x >= grid.length) {
        return;
    }
    sum += grid[x][y];
    if (sum >= minGrid[x][y]) {
        return;
    } else {
        minGrid[x][y] = sum;
    }
    for (let i = 0; i < grid[x].length; i++) {
        dfs(grid, moveCost, sum + moveCost[grid[x][y]][i], x + 1, i);
    }
}
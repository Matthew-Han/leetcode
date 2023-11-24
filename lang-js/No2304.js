let minGrid;
/**
 * 网格中的最小路径代价
 * @param grid
 * @param moveCost
 */
let minPathCost = (grid, moveCost) => {
    let ans = 0x3f3f3f3f;
    minGrid = createGrid(grid.length, grid[grid.length - 1].length, 0x3f3f3f3f);
    dfs(grid, moveCost, 0, 0, 0);
    for (let i = 0; i < minGrid[minGrid.length - 1].length; i++) {
        ans = Math.min(ans, minGrid[minGrid.length - 1][i]);
    }
    return ans;
};

let dfs = (grid, moveCost, sum, x, y) => {
    sum += grid[x][y];
    if (sum >= minGrid[x][y]) {
        return;
    } else {
        minGrid[x][y] = sum;
    }
    if (y < grid[grid.length - 1].length - 1) {
        for (let i = 0; i < grid[x].length; i++) {
            dfs(grid, moveCost, sum + moveCost[grid[x][y]][i], x + 1, i);
        }
    }
}


let createGrid = (m, n, val) => {
    let arr = [];
    for (let i = 0; i < m; i++) {
        arr[i] = [];
        for (let j = 0; j < n; j++) {
            arr[i][j] = val;
        }
    }
    return arr;
}


minPathCost([[5, 3], [4, 0], [2, 1]], [[9, 8], [1, 5], [10, 12], [18, 6], [2, 4], [14, 3]])
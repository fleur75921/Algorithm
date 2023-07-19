const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = Array.from(Array(N), (_, i) => input[i + 1].split(" ").map(Number));
const visited = Array.from(Array(N), () => Array(M));
let max = -Infinity;

const dfs = (r, c, sum) => {
    if (r == N) {
        if (sum > max) {
            max = sum;
        }
        return;
    }
    if (!visited[r][c]) {
        if (r - 1 >= 0 && !visited[r - 1][c]) {
            if (c - 1 >= 0 && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c - 1] = true;
                if (c != M - 1) {
                    dfs(
                        r,
                        c + 1,
                        sum + 2 * map[r][c] + map[r - 1][c] + map[r][c - 1]
                    );
                } else {
                    dfs(
                        r + 1,
                        0,
                        sum + 2 * map[r][c] + map[r - 1][c] + map[r][c - 1]
                    );
                }
                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c - 1] = false;
            }
            if (c + 1 < M && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c + 1] = true;
                if (c != M - 1) {
                    dfs(
                        r,
                        c + 1,
                        sum + 2 * map[r][c] + map[r - 1][c] + map[r][c + 1]
                    );
                } else {
                    dfs(
                        r + 1,
                        0,
                        sum + 2 * map[r][c] + map[r - 1][c] + map[r][c + 1]
                    );
                }
                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c + 1] = false;
            }
        }
        if (r + 1 < N && !visited[r + 1][c]) {
            if (c - 1 >= 0 && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c - 1] = true;
                if (c != M - 1) {
                    dfs(
                        r,
                        c + 1,
                        sum + 2 * map[r][c] + map[r + 1][c] + map[r][c - 1]
                    );
                } else {
                    dfs(
                        r + 1,
                        0,
                        sum + 2 * map[r][c] + map[r + 1][c] + map[r][c - 1]
                    );
                }
                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c - 1] = false;
            }
            if (c + 1 < M && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c + 1] = true;
                if (c != M - 1) {
                    dfs(
                        r,
                        c + 1,
                        sum + 2 * map[r][c] + map[r + 1][c] + map[r][c + 1]
                    );
                } else {
                    dfs(
                        r + 1,
                        0,
                        sum + 2 * map[r][c] + map[r + 1][c] + map[r][c + 1]
                    );
                }
                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c + 1] = false;
            }
        }
    }

    if (c != M - 1) {
        dfs(r, c + 1, sum);
    } else {
        dfs(r + 1, 0, sum);
    }
};

dfs(0, 0, 0);
console.log(max);

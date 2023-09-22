const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = [];

for (let i = 0; i < N; i++) {
    map[i] = input[i + 1].split("");
}

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
const visited = Array.from(Array(N), () => Array(M).fill(false));

getMax = (r, c) => {
    let res = 0;
    loop: while (true) {
        for (let i = 0; i < 4; i++) {
            const nr = r + (res + 1) * dr[i];
            const nc = c + (res + 1) * dc[i];
            if (
                nr < 0 ||
                nc < 0 ||
                nr >= N ||
                nc >= M ||
                map[nr][nc] === "." ||
                visited[nr][nc]
            ) {
                break loop;
            }
        }
        res++;
    }
    return res;
};

let ans = 0;
const dfs = (r, c, cnt, mul) => {
    if (cnt === 2) {
        if (mul > ans) {
            ans = mul;
        }
        return;
    }
    if (r === N) {
        return;
    }

    if (!visited[r][c] && map[r][c] === "#") {
        const max = getMax(r, c);
        for (let i = 0; i <= max; i++) {
            visited[r][c] = true;
            for (let j = 1; j <= i; j++) {
                for (let k = 0; k < 4; k++) {
                    const nr = r + j * dr[k];
                    const nc = c + j * dc[k];
                    visited[nr][nc] = true;
                }
            }
            if (c < M - 1) {
                dfs(r, c + 1, cnt + 1, mul * (4 * i + 1));
            } else {
                dfs(r + 1, 0, cnt + 1, mul * (4 * i + 1));
            }
            visited[r][c] = false;
            for (let j = 1; j <= i; j++) {
                for (let k = 0; k < 4; k++) {
                    const nr = r + j * dr[k];
                    const nc = c + j * dc[k];
                    visited[nr][nc] = false;
                }
            }
        }
    }
    if (c < M - 1) {
        dfs(r, c + 1, cnt, mul);
    } else {
        dfs(r + 1, 0, cnt, mul);
    }
};

dfs(0, 0, 0, 1);
console.log(ans);

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = [];
for (let i = 1; i <= N; i++) {
    map[i - 1] = input[i].split("");
}

const visited = Array.from(Array(N), () => Array(M).fill(false));
const dr = [];
const dc = [];
for (let i = 0; i < M; i++) {
    dr[i] = 0;
    dc[i] = i;
}
for (let i = M; i < M + N - 1; i++) {
    dr[i] = i - M + 1;
    dc[i] = 0;
}

let max = 0;
const dfs = (r, c, sum) => {
    if (r === N) {
        if (sum > max) {
            max = sum;
        }
        return;
    }
    if (visited[r][c]) {
        if (c !== M - 1) {
            dfs(r, c + 1, sum);
        } else {
            dfs(r + 1, 0, sum);
        }
        return;
    } else {
        loop: for (let i = 0; i < N + M - 1; i++) {
            const nr = r + dr[i];
            const nc = c + dc[i];
            if (nr >= N) continue;
            if (nc >= M) continue;
            let tmp = "";
            const store = [];
            if (dr[i] === 0) {
                for (let j = c; j <= nc; j++) {
                    if (visited[nr][j]) {
                        store.forEach((item) => {
                            visited[item[0]][item[1]] = false;
                        });
                        continue loop;
                    }
                    visited[nr][j] = true;
                    tmp += map[nr][j];
                    store.push([nr, j]);
                }
            } else {
                for (let j = r; j <= nr; j++) {
                    if (visited[j][nc]) {
                        store.forEach((item) => {
                            visited[item[0]][item[1]] = false;
                        });
                        continue loop;
                    }
                    visited[j][nc] = true;
                    tmp += map[j][nc];
                    store.push([j, nc]);
                }
            }
            if (c !== M - 1) {
                dfs(r, c + 1, sum + Number(tmp));
            } else {
                dfs(r + 1, 0, sum + Number(tmp));
            }
            store.forEach((item) => {
                visited[item[0]][item[1]] = false;
            });
        }
    }
};

dfs(0, 0, 0);
console.log(max);

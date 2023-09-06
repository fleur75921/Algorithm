const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const cur = input[1].split("").map(Number);
const next = input[2].split("").map(Number);

let ans = Infinity;

const dfs = (n, clicked, needed, cnt) => {
    if (n == N) {
        if (needed) {
            ans = Math.min(ans, cnt);
        }
        return;
    }

    if (clicked) {
        if (needed) {
            if (cur[n] === next[n]) {
                dfs(n + 1, false, false, cnt);
            } else {
                dfs(n + 1, false, true, cnt);
            }
        } else {
            if (cur[n] === next[n]) {
                dfs(n + 1, true, true, cnt + 1);
            } else {
                dfs(n + 1, true, false, cnt + 1);
            }
        }
    } else {
        if (needed) {
            if (cur[n] === next[n]) {
                dfs(n + 1, false, true, cnt);
            } else {
                dfs(n + 1, false, false, cnt);
            }
        } else {
            if (cur[n] === next[n]) {
                dfs(n + 1, true, false, cnt + 1);
            } else {
                dfs(n + 1, true, true, cnt + 1);
            }
        }
    }
};

dfs(0, false, true, 0);
dfs(0, false, false, 0);

console.log(ans === Infinity ? -1 : ans);

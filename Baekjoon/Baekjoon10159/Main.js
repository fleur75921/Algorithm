const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const M = +input[1];
const dist = Array.from(Array(N + 1), () => Array(N + 1).fill(Infinity));
for (let i = 2; i < 2 + M; i++) {
    const [from, to] = input[i].split(" ").map(Number);
    dist[from][to] = 1;
}

for (let k = 1; k <= N; k++) {
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= N; j++) {
            if (dist[i][k] + dist[k][j] < dist[i][j]) {
                dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
}

const ans = [];
for (let i = 1; i <= N; i++) {
    let tmp = 0;
    for (let j = 1; j <= N; j++) {
        if (i === j) continue;
        if (dist[i][j] !== Infinity || dist[j][i] !== Infinity) {
            tmp++;
        }
    }
    ans.push(N - tmp - 1);
}

console.log(ans.join("\n"));

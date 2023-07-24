const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

class Node {
    constructor(v, w, link) {
        this.v = v;
        this.w = w;
        this.link = link;
    }
}

const [n, m, r] = input[0].split(" ").map(Number);
const items = input[1].split(" ").map(Number);
const dist = Array.from(Array(n + 1), () => Array(n + 1).fill(Infinity));

for (let i = 2; i < 2 + r; i++) {
    [from, to, w] = input[i].split(" ").map(Number);
    dist[from][to] = w;
    dist[to][from] = w;
}

for (let i = 1; i <= n; i++) {
    dist[i][i] = 0;
}

for (let k = 1; k <= n; k++) {
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= n; j++) {
            if (dist[i][j] > dist[i][k] + dist[k][j]) {
                dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
}

let tmp;
let max = -Infinity;

for (let i = 1; i <= n; i++) {
    tmp = 0;
    for (let j = 1; j <= n; j++) {
        if (dist[i][j] <= m) {
            tmp += items[j - 1];
        }
    }
    if (tmp > max) {
        max = tmp;
    }
}

console.log(max);

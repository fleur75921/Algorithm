const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const gender = input[1].split(" ");
const edges = [];

const parents = Array.from(Array(N + 1), (_, i) => i);
const ranks = Array(N + 1).fill(1);

const find = (a) => {
    if (parents[a] === a) return a;
    return (parents[a] = find(parents[a]));
};

const union = (a, b) => {
    let aRoot = find(a);
    let bRoot = find(b);

    if (aRoot === bRoot) return false;

    if (ranks[aRoot] < ranks[bRoot]) [aRoot, bRoot] = [bRoot, aRoot];

    parents[bRoot] = aRoot;
    if (ranks[aRoot] === ranks[bRoot]) ranks[aRoot]++;

    return true;
};

for (let i = 2; i < 2 + M; i++) {
    edges.push(input[i].split(" ").map(Number));
}

edges.sort((a, b) => a[2] - b[2]);
let cnt = 0;
let ans = 0;
let found = false;

for (let i = 0; i < edges.length; i++) {
    const edge = edges[i];
    if (gender[edge[0] - 1] === gender[edge[1] - 1]) continue;

    if (union(edge[0], edge[1])) {
        ans += edge[2];
        cnt++;
    }

    if (cnt === N - 1) {
        found = true;
        break;
    }
}

console.log(found ? ans : -1);

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const [s, e] = input[1].split(" ").map(Number);

const parents = Array.from(Array(N + 1), (_, i) => i);
const ranks = Array(N + 1).fill(1);

let min = Infinity;

const find = (a) => {
    if (a === parents[a]) return a;
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

const edges = [];

for (let i = 2; i < 2 + M; i++) {
    edges.push(input[i].split(" ").map(Number));
}

edges.sort((a, b) => b[2] - a[2]);
let found = false;

for (let i = 0; i < edges.length; i++) {
    if (union(edges[i][0], edges[i][1])) {
        min = edges[i][2];
        if (find(s) === find(e)) {
            found = true;
            break;
        }
    }
}

console.log(found ? min : 0);

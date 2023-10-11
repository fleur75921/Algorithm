const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);

const parents = Array.from(Array(N + 1), (_, i) => i);
const ranks = Array(N + 1).fill(1);

const find = (a) => {
    if (a === parents[a]) {
        return a;
    }
    return (parents[a] = find(parents[a]));
};

const union = (a, b) => {
    let aRoot = find(a);
    let bRoot = find(b);
    if (aRoot === bRoot) {
        return false;
    }
    if (ranks[aRoot] < ranks[bRoot]) {
        [aRoot, bRoot] = [bRoot, aRoot];
    }
    parents[bRoot] = aRoot;
    if (ranks[aRoot] === ranks[bRoot]) {
        ranks[aRoot]++;
    }
    return true;
};

const getDist = (x1, y1, x2, y2) => {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
};

const point = [];
for (let i = 1; i <= N; i++) {
    point.push(input[i].split(" ").map(Number));
}
const Edges = [];
for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (i === j) continue;
        const dist = getDist(
            point[i][0],
            point[i][1],
            point[j][0],
            point[j][1]
        );
        Edges.push([i + 1, j + 1, dist]);
    }
}
Edges.sort((a, b) => a[2] - b[2]);
let cnt = 0;
for (let i = N + 1; i < N + 1 + M; i++) {
    const [X, Y] = input[i].split(" ").map(Number);
    if (union(X, Y)) cnt++;
}

let ans = 0;

for (edge of Edges) {
    if (cnt >= N - 1) {
        break;
    }
    if (union(edge[0], edge[1])) {
        cnt++;
        ans += edge[2];
    }
}

console.log(ans.toFixed(2));

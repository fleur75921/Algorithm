const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
let ans = 0;
const edges = [];
for (let i = 1; i <= M; i++) {
    edges[i - 1] = input[i].split(" ").map(Number);
    ans += edges[i - 1][2];
}

const parents = Array.from(Array(N + 1), (_, i) => i);
const ranks = Array(N + 1).fill(1);

const find = (a) => {
    if (parents[a] === a) {
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

let cnt = 0;

edges.sort((a, b) => a[2] - b[2]);
edges.forEach((edge) => {
    if (union(edge[0], edge[1])) {
        ans -= edge[2];
        cnt++;
    }
});

if (cnt === N - 1) {
    console.log(ans);
} else {
    console.log(-1);
}

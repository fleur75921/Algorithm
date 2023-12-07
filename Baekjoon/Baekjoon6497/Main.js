const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

let parents, ranks;

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

const ans = [];
let idx = 0;

while (true) {
    const [m, n] = input[idx++].split(" ").map(Number);
    if (m === 0 && n === 0) break;
    parents = Array.from(Array(m), (_, i) => i);
    ranks = Array(m).fill(1);
    let wSum = 0;
    const edges = [];

    for (let i = idx; i < idx + n; i++) {
        const [x, y, z] = input[i].split(" ").map(Number);
        edges.push([x, y, z]);
        wSum += z;
    }
    idx += n;

    let min = 0;

    edges.sort((a, b) => a[2] - b[2]);
    let cnt = 0;
    edges.forEach((edge) => {
        if (union(edge[0], edge[1])) {
            min += edge[2];
            cnt++;
            if (cnt === m - 1) return;
        }
    });
    ans.push(wSum - min);
}

console.log(ans.join("\n"));

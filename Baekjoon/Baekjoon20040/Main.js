const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ").map(Number);

const parents = Array.from(Array(n), (_, i) => i);

const ranks = Array(n).fill(1);

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

let found = false;

for (let i = 1; i <= m; i++) {
    const [A, B] = input[i].split(" ").map(Number);
    if (!union(A, B)) {
        console.log(i);
        found = true;
        break;
    }
}

if (!found) {
    console.log(0);
}

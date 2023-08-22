const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = Number(input[0]);
const planets = [];
for (let i = 1; i <= N; i++) {
    const planet = input[i].split(" ").map(Number);
    planet.push(i - 1);
    planets.push(planet);
}

const getCost = (a, b) => {
    return Math.min(
        Math.abs(a[0] - b[0]),
        Math.abs(a[1] - b[1]),
        Math.abs(a[2] - b[2])
    );
};

const edges = [];
planets.sort((a, b) => a[0] - b[0]);
for (let i = 0; i < N - 1; i++) {
    edges.push([
        planets[i][3],
        planets[i + 1][3],
        getCost(planets[i], planets[i + 1]),
    ]);
}
planets.sort((a, b) => a[1] - b[1]);
for (let i = 0; i < N - 1; i++) {
    edges.push([
        planets[i][3],
        planets[i + 1][3],
        getCost(planets[i], planets[i + 1]),
    ]);
}
planets.sort((a, b) => a[2] - b[2]);
for (let i = 0; i < N - 1; i++) {
    edges.push([
        planets[i][3],
        planets[i + 1][3],
        getCost(planets[i], planets[i + 1]),
    ]);
}

const parents = Array.from(Array(N), (_, i) => i);
const ranks = Array.from(Array(N), () => 1);
const find = (a) => {
    if (parents[a] === a) {
        return a;
    }
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

let ans = 0;
let cnt = 0;
edges.sort((a, b) => a[2] - b[2]);
for (let i = 0; i < edges.length; i++) {
    if (union(edges[i][0], edges[i][1])) {
        ans += edges[i][2];
        if (++cnt === N - 1) break;
    }
}

console.log(ans);

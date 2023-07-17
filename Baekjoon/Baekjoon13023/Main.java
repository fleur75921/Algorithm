const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

class Node {
    constructor(v, link) {
        this.v = v;
        this.link = link;
    }
}

const dfs = (n, v, visited) => {
    if (n == 5) {
        console.log(1);
        process.exit(0);
    }
    for (let nd = adjList[v]; nd != null; nd = nd.link) {
        if (!visited[nd.v]) {
            visited[nd.v] = true;
            dfs(n + 1, nd.v, visited);
            visited[nd.v] = false;
        }
    }
};

const [N, M] = input[0].split(" ").map(Number);
const adjList = [];
let from, to;
for (let i = 1; i <= M; i++) {
    [from, to] = input[i].split(" ").map(Number);
    adjList[from] = new Node(to, adjList[from]);
    adjList[to] = new Node(from, adjList[to]);
}
for (let i = 0; i < N; i++) {
    const visited = [];
    visited[i] = true;
    dfs(1, i, visited);
}

console.log(0);

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];

class Node {
    constructor(item, w, link) {
        this.item = item;
        this.w = w;
        this.link = link;
    }
}

const adjList = [];

for (let i = 1; i < n; i++) {
    const [from, to, w] = input[i].split(" ").map(Number);
    adjList[from] = new Node(to, w, adjList[from]);
    adjList[to] = new Node(from, w, adjList[to]);
}

let far;
let max = -Infinity;
let visited = Array(n + 1).fill(false);

const findFarthest = (v, dist) => {
    if (dist > max) {
        max = dist;
        far = v;
    }
    for (let n = adjList[v]; n != null; n = n.link) {
        if (!visited[n.item]) {
            visited[n.item] = true;
            findFarthest(n.item, dist + n.w);
        }
    }
};

visited[1] = true;
findFarthest(1, 0);

max = -Infinity;
visited = Array(n + 1).fill(false);

visited[far] = true;
findFarthest(far, 0);

console.log(max);

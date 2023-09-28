const { timingSafeEqual } = require("crypto");

let input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

class Node {
    constructor(item, link) {
        this.item = item;
        this.link = link;
    }
}

class Queue {
    constructor() {
        this.head = null;
        this.tail = null;
        this.cnt = 0;
    }

    isEmpty() {
        return this.cnt === 0;
    }

    offer(item) {
        const n = new Node(item, null);
        if (this.isEmpty()) {
            this.head = n;
            this.tail = n;
        } else {
            this.tail.link = n;
            this.tail = n;
        }
        this.cnt++;
    }

    poll() {
        if (this.isEmpty()) {
            return -1;
        }
        const res = this.head;
        if (this.cnt !== 1) {
            this.head = this.head.link;
        } else {
            this.head = null;
        }
        this.cnt--;
        return res.item;
    }
}

class Edge {
    constructor(to, w, dist, link) {
        this.to = to;
        this.w = w;
        this.dist = dist;
        this.link = link;
    }
}

const [N, R] = input[0].split(" ").map(Number);
const adjList = [];
for (let i = 1; i < N; i++) {
    const [a, b, d] = input[i].split(" ").map(Number);
    adjList[a] = new Edge(b, d, 0, adjList[a]);
    adjList[b] = new Edge(a, d, 0, adjList[b]);
}
const q = new Queue();
const visited = Array(N + 1).fill(false);
visited[R] = true;
q.offer(new Edge(R, 0, 0, null));
let found = false;
let giga;
let gigaDist;
let max = -Infinity;
while (!q.isEmpty()) {
    const cur = q.poll();
    if (cur.dist > max) {
        max = cur.dist;
    }
    let cnt = 0;
    for (let e = adjList[cur.to]; e != null; e = e.link) {
        if (!visited[e.to]) {
            cnt++;
            if (!found && cnt > 1) {
                giga = cur.to;
                gigaDist = cur.dist;
                found = true;
            }
            visited[e.to] = true;
            q.offer(new Edge(e.to, 0, cur.dist + e.w, null));
        }
    }
}

if (giga === undefined) {
    console.log(max, 0);
} else {
    console.log(gigaDist, max - gigaDist);
}

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = [];
for (let i = 1; i <= N; i++) {
    map[i - 1] = input[i].split(" ").map(Number);
}
let [H, W, Sr, Sc, Fr, Fc] = input[N + 1].split(" ").map(Number);
Sr--;
Sc--;
Fr--;
Fc--;

class Node {
    constructor(item) {
        this.item = item;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.head = null;
        this.tail = null;
        this.idx = 0;
    }

    isEmpty() {
        if (this.idx === 0) {
            return true;
        }
        return false;
    }

    size() {
        return this.idx;
    }

    offer(item) {
        const node = new Node(item);
        if (this.idx === 0) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.idx++;
    }

    poll() {
        const res = this.head;
        if (this.idx > 0) {
            this.head = this.head.next;
            this.idx--;
        }
        return res.item;
    }
}

const q = new Queue();
const visited = Array.from(Array(N), () => Array(M).fill(false));
q.offer([Sr, Sc]);
visited[Sr][Sc] = true;
const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
let ans = 0;
let found = false;

wloop: while (!q.isEmpty()) {
    const size = q.size();
    ans++;
    for (let s = 0; s < size; s++) {
        const cur = q.poll();
        loop: for (let i = 0; i < 4; i++) {
            const r = cur[0] + dr[i];
            const c = cur[1] + dc[i];
            if (r < 0 || c < 0 || r + H > N || c + W > M || visited[r][c])
                continue;
            if (i === 0) {
                for (let j = cur[1]; j < cur[1] + W; j++) {
                    if (map[r][j] === 1) continue loop;
                }
            } else if (i === 1) {
                for (let j = cur[1]; j < cur[1] + W; j++) {
                    if (map[r + H - 1][j] === 1) continue loop;
                }
            } else if (i === 2) {
                for (let j = cur[0]; j < cur[0] + H; j++) {
                    if (map[j][c] === 1) continue loop;
                }
            } else {
                for (let j = cur[0]; j < cur[0] + H; j++) {
                    if (map[j][c + W - 1] === 1) continue loop;
                }
            }
            visited[r][c] = true;
            q.offer([r, c]);
            if (r === Fr && c === Fc) {
                found = true;
                break wloop;
            }
        }
    }
}

if (found) {
    console.log(ans);
} else {
    console.log(-1);
}

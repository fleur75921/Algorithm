const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = [];
for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map(Number));
}

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
let start, cnt, cnt2;

const update = () => {
    const tmp = Array.from(Array(N), () => Array(M).fill(0));
    let found = false;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (map[i][j] === 0) continue;
            for (let k = 0; k < 4; k++) {
                const nr = i + dr[k];
                const nc = j + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[nr][nc] === 0) {
                    found = true;
                    tmp[i][j]++;
                }
            }
        }
    }
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            map[i][j] -= tmp[i][j];
            if (map[i][j] < 0) {
                map[i][j] = 0;
            }
            if (map[i][j] > 0) {
                cnt++;
                start = [i, j];
            }
        }
    }
    return found;
};

const count = (r, c, v) => {
    for (let i = 0; i < 4; i++) {
        const nr = r + dr[i];
        const nc = c + dc[i];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        if (map[nr][nc] > 0 && !v[nr][nc]) {
            cnt2++;
            v[nr][nc] = true;
            count(nr, nc, v);
        }
    }
};

let answer = 0;

while (true) {
    answer++;
    start = null;
    const v = Array.from(Array(N), () => Array(M).fill(false));
    cnt = 0;
    cnt2 = 1;
    if (!update()) {
        break;
    }
    if (start) {
        v[start[0]][start[1]] = true;
        count(start[0], start[1], v);
        if (cnt !== cnt2) {
            console.log(answer);
            process.exit(0);
        }
    }
}

console.log(0);

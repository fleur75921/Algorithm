const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const map = Array.from(Array(N), () => Array.from(Array(M), () => Array(3)));
map[0] = input[1].split(" ").map((item) => [+item, +item, +item]);

for (let i = 2; i <= N; i++) {
    const tmp = input[i].split(" ").map(Number);
    for (let j = 0; j < M; j++) {
        if (j !== 0) {
            map[i - 1][j][0] =
                tmp[j] + Math.min(map[i - 2][j - 1][1], map[i - 2][j - 1][2]);
        } else {
            map[i - 1][j][0] = Infinity;
        }
        map[i - 1][j][1] =
            tmp[j] + Math.min(map[i - 2][j][0], map[i - 2][j][2]);
        if (j !== M - 1) {
            map[i - 1][j][2] =
                tmp[j] + Math.min(map[i - 2][j + 1][0], map[i - 2][j + 1][1]);
        } else {
            map[i - 1][j][2] = Infinity;
        }
    }
}

let ans = Infinity;

for (let i = 0; i < M; i++) {
    for (let j = 0; j < 3; j++) {
        if (map[N - 1][i][j] < ans) {
            ans = map[N - 1][i][j];
        }
    }
}

console.log(ans);

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];

const map = [];
for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map(Number));
}
const pSum = Array.from(Array(N + 1), () => Array(N + 1).fill(0));
for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
        pSum[i][j] = pSum[i][j - 1] + map[i - 1][j - 1];
    }
    for (let j = 1; j <= N; j++) {
        pSum[i][j] += pSum[i - 1][j];
    }
}

let max = -Infinity;

for (let k = 0; k < N; k++) {
    for (let i = 0; i < N - k; i++) {
        for (let j = 0; j < N - k; j++) {
            const tmp =
                pSum[i + k + 1][j + k + 1] -
                pSum[i + k + 1][j] -
                pSum[i][j + k + 1] +
                pSum[i][j];
            if (tmp > max) max = tmp;
        }
    }
}

console.log(max);

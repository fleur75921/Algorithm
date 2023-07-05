const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = Number(input[0]);
const honey = input[1].split(" ").map(Number);
const partialSum = [];
const partialSumReverse = [];

partialSum[0] = honey[0];
for (let i = 1; i < N; i++) {
    partialSum[i] = partialSum[i - 1] + honey[i];
}
partialSumReverse[N - 1] = honey[N - 1];
for (let i = N - 2; i >= 0; i--) {
    partialSumReverse[i] = partialSumReverse[i + 1] + honey[i];
}

let bee1, bee2;
let max = 0;
let tmp;

// 벌통이 오른쪽 끝
bee1 = partialSum[N - 1] - honey[0];
for (let i = 1; i <= N - 2; i++) {
    bee2 = partialSum[N - 1] - partialSum[i];
    tmp = bee1 - honey[i] + bee2;
    if (tmp > max) {
        max = tmp;
    }
}

// 벌통이 왼쪽 끝
bee1 = partialSumReverse[0] - honey[N - 1];
for (let i = N - 2; i >= 1; i--) {
    bee2 = partialSumReverse[0] - partialSumReverse[i];
    tmp = bee1 - honey[i] + bee2;
    if (tmp > max) {
        max = tmp;
    }
}

// 벌통이 가운데
for (let i = 1; i <= N - 2; i++) {
    bee1 = partialSum[i] - honey[0];
    bee2 = partialSumReverse[i] - honey[N - 1];
    tmp = bee1 + bee2;
    if (tmp > max) {
        max = tmp;
    }
}

console.log(max);

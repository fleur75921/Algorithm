const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const pSum = Array.from(Array(N + 1), () => Array(M + 1).fill(0));
for (let i = 1; i <= N; i++) {
    input[i].split(" ").map((item, j) => {
        pSum[i][j + 1] = pSum[i][j] + Number(item);
    });
    pSum[i].map((_, j) => {
        pSum[i][j + 1] += pSum[i - 1][j + 1];
    });
}

const K = Number(input[N + 1]);
const ans = [];
for (let i = N + 2; i < N + 2 + K; i++) {
    const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
    ans.push(
        pSum[x2][y2] -
            pSum[x1 - 1][y2] -
            pSum[x2][y1 - 1] +
            pSum[x1 - 1][y1 - 1]
    );
}
console.log(ans.join("\n"));

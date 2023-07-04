const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let N,
    T = [],
    P = [],
    dp = [],
    input = [];

const solve = () => {
    for (let i = 1; i <= N; i++) {
        if (dp[i] < dp[i - 1]) {
            dp[i] = dp[i - 1];
        }
        if (dp[i - 1] + P[i] > dp[i + T[i] - 1]) {
            dp[i + T[i] - 1] = dp[i - 1] + P[i];
        }
    }
    return dp[N];
};

rl.on("line", (line) => {
    input.push(line);
}).on("close", () => {
    N = Number(input[0]);
    dp = new Array(N + 1).fill(0);
    for (let i = 1; i <= N; i++) {
        [T[i], P[i]] = input[i].trim().split(" ").map(Number);
    }
    console.log(solve());
    process.exit();
});

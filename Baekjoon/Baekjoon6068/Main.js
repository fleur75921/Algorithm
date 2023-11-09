const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const times = [];

for (let i = 1; i <= N; i++) {
    times.push(input[i].split(" ").map(Number));
}

const sum = times.reduce((a, b) => a[0] + b[1]);
times.sort((a, b) => a[1] - b[1]);
let time = 0;
let min = Infinity;
for (let i = 0; i < N; i++) {
    time += times[i][0];
    if (time > times[i][1]) {
        console.log(-1);
        process.exit(0);
    }
    if (times[i][1] - time < min) {
        min = times[i][1] - time;
    }
}

console.log(min);

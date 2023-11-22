const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const arr = [];
for (let i = 1; i <= N; i++) {
    arr.push(+input[i]);
}
arr.sort((a, b) => a - b);

let left = 0,
    right = 0;
let min = Infinity;
while (left < N) {
    const tmp = arr[right] - arr[left];
    if (tmp >= M && tmp < min) {
        min = tmp;
    }
    if (left === right) {
        right++;
        continue;
    }
    if (tmp < M) {
        right++;
    } else {
        left++;
    }
}

console.log(min);

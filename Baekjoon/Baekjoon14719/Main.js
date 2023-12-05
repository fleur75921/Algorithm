const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [R, C] = input[0].split(" ").map(Number);
const height = input[1].split(" ").map(Number);
let ans = 0;

for (let i = 0; i < C; i++) {
    let left = 0,
        right = 0;
    for (let j = 0; j < i; j++) {
        left = Math.max(left, height[j]);
    }
    for (let j = C - 1; j > i; j--) {
        right = Math.max(right, height[j]);
    }
    ans += Math.max(0, Math.min(left, right) - height[i]);
}

console.log(ans);

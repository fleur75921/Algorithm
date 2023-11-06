const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const arr = input[1].split(" ").map(Number);
const brr = new Set();

const isPrime = Array(1000001).fill(true);
isPrime[1] = false;
for (let i = 2; i < 1000001; i++) {
    if (isPrime[i]) {
        for (let j = i * i; j < 1000001; j += i) {
            isPrime[j] = false;
        }
    }
}

for (let i = 0; i < N; i++) {
    if (isPrime[arr[i]]) {
        brr.add(arr[i]);
    }
}

let ans;
if (brr.size === 0) {
    ans = -1;
} else {
    ans = [...brr].reduce((a, b) => BigInt(a) * BigInt(b)).toString();
}
console.log(ans);

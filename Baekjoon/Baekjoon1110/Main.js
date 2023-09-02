const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];

const make = (n) => {
    const q = n / 10;
    const r = n % 10;
    return Math.floor(r * 10 + ((q + r) % 10));
};

let next = make(N);
let ans = 1;

while (N !== next) {
    next = make(next);
    ans++;
}

console.log(ans);

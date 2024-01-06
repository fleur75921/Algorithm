const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const pos = [];
const neg = [];
let hasZero = false;

for (let i = 1; i <= N; i++) {
    const num = +input[i];
    if (num > 0) {
        pos.push(num);
    } else if (num < 0) {
        neg.push(num);
    } else {
        hasZero = true;
    }
}

pos.sort((a, b) => a - b);
neg.sort((a, b) => a - b);

let ans = 0;
if (pos.length % 2 === 0) {
    for (let i = 0; i < pos.length; i += 2) {
        ans += pos[i] * pos[i + 1];
    }
} else {
    ans += pos[0];
    for (let i = 1; i < pos.length; i += 2) {
        ans += pos[i] * pos[i + 1];
    }
}

if (neg.length % 2 === 0) {
    for (let i = 0; i < neg.length; i += 2) {
        ans += neg[i] * neg[i + 1];
    }
} else {
    if (hasZero) {
        for (let i = 0; i < neg.length - 1; i += 2) {
            ans += neg[i] * neg[i + 1];
        }
    } else {
        ans += neg[neg.length - 1];
        for (let i = 0; i < neg.length - 1; i += 2) {
            ans += neg[i] * neg[i + 1];
        }
    }
}

console.log(ans);

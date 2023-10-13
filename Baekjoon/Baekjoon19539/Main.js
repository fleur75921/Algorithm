const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const h = input[1].split(" ").map(Number);

const sum = h.reduce((prev, cur) => prev + cur);
if (sum % 3 !== 0) {
    console.log("NO");
    process.exit(0);
}
let twos = Math.floor(sum / 3);
for (let i = 0; i < h.length; i++) {
    twos -= Math.floor(h[i] / 2);
}
if (twos > 0) {
    console.log("NO");
    process.exit(0);
}
console.log("YES");

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const A = input[0];
const B = input[1];

const As = Array(26).fill(0);
const Bs = Array(26).fill(0);

for (let i = 0; i < A.length; i++) {
    As[A.charAt(i).charCodeAt(0) - "A".charCodeAt(0)]++;
    Bs[B.charAt(i).charCodeAt(0) - "A".charCodeAt(0)]++;
}
for (let i = 0; i < 26; i++) {
    if (As[i] !== Bs[i]) {
        console.log(-1);
        process.exit(0);
    }
}

let ans = 0;
let a = A.length - 1;
let b = a;

while (a >= 0) {
    if (A.charAt(a) !== B.charAt(b)) {
        ans++;
    } else {
        b--;
    }
    a--;
}

console.log(ans);

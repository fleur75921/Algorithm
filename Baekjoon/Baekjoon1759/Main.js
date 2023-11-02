const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [L, C] = input[0].split(" ").map(Number);
const arr = input[1].split(" ");
arr.sort();
const res = [];
const vowel = new Set(["a", "e", "i", "o", "u"]);

const ans = [];
const comb = (n, start, con, vow) => {
    if (n === L) {
        if (vow < 1) return;
        if (con < 2) return;
        ans.push(res.join(""));
        return;
    }
    for (let i = start; i < C; i++) {
        res[n] = arr[i];
        if (vowel.has(res[n])) {
            comb(n + 1, i + 1, con, vow + 1);
        } else {
            comb(n + 1, i + 1, con + 1, vow);
        }
    }
};

comb(0, 0, 0, 0);

console.log(ans.join("\n"));

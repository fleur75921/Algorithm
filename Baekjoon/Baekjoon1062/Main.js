const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const words = [];
for (let i = 1; i <= N; i++) {
    let bit = 0;
    const str = input[i];
    for (let j = 0; j < str.length; j++) {
        for (let k = 0; k < 26; k++) {
            if (str.charCodeAt(j) === "a".charCodeAt(0) + k) {
                bit |= 1 << k;
            }
        }
    }
    words.push(bit);
}
let ans = 0;
let origin = 0;
const init = [0, 2, 8, 13, 19];
init.forEach((item) => {
    origin |= 1 << item;
});
const R = K - 5;

const rest = [
    1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25,
];
let res = [];

const comb = (n, start) => {
    if (n === R) {
        let tmp = origin;
        res.forEach((item) => {
            tmp |= 1 << item;
        });
        let cnt = 0;
        words.forEach((word) => {
            if ((word & tmp) === word) {
                cnt++;
            }
        });
        if (cnt > ans) {
            ans = cnt;
        }
        return;
    }

    for (let i = start; i < 21; i++) {
        res[n] = rest[i];
        comb(n + 1, i + 1);
    }
};

comb(0, 0);
console.log(ans);

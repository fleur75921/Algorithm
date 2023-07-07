const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = Number(input[0]);
const result = [];

const np = (str) => {
    let N = str.length;
    let i = N - 1;
    while (i > 0 && str[i - 1] >= str[i]) i--;

    if (i == 0) return false;

    let j = N - 1;
    while (str[i - 1] >= str[j]) j--;

    [str[i - 1], str[j]] = [str[j], str[i - 1]];

    let k = N - 1;
    while (i < k) {
        [str[i], str[k]] = [str[k], str[i]];
        i++;
        k--;
    }

    return true;
};

for (let i = 1; i <= N; i++) {
    let str = [...input[i]].sort();
    do {
        result.push(str.join(""));
    } while (np(str));
}

console.log(result.join("\n"));

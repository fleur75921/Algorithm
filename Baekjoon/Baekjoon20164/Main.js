const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];

const write = (num) => {
    let res = 0;
    const arr = String(num).split("").map(Number);
    arr.map((item) => {
        if (item % 2 !== 0) {
            res++;
        }
    });
    return res;
};

const sumTwo = (num) => {
    const arr = String(num).split("").map(Number);
    return arr.reduce((prev, cur) => prev + cur);
};

const divide = (num, left, right) => {
    const arr = String(num).split("").map(Number);
    const one = [],
        two = [],
        three = [];
    for (let i = 0; i <= left; i++) {
        one.push(arr[i]);
    }
    for (let i = left + 1; i < right; i++) {
        two.push(arr[i]);
    }
    for (let i = right; i < arr.length; i++) {
        three.push(arr[i]);
    }
    return Number(one.join("")) + Number(two.join("")) + Number(three.join(""));
};

let max = -Infinity,
    min = Infinity;

const dfs = (num, sum) => {
    sum += write(num);
    const len = Math.floor(Math.log10(num)) + 1;
    if (len === 1) {
        if (sum > max) {
            max = sum;
        }
        if (sum < min) {
            min = sum;
        }
        return;
    }
    if (len === 2) {
        dfs(sumTwo(num), sum);
    } else {
        for (let i = 0; i < len - 2; i++) {
            for (let j = i + 2; j < len; j++) {
                dfs(divide(num, i, j), sum);
            }
        }
    }
};

dfs(N, 0);
console.log(min, max);

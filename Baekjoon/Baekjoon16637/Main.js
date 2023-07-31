const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = Number(input[0]);
const len = Math.floor(N / 2);
let max = -Infinity;

const arr = input[1].split("").map((item, index) => {
    if (index % 2 == 0) {
        return Number(item);
    } else {
        return item;
    }
});

const calculate = (oper, a, b) => {
    if (oper === "+") {
        return a + b;
    } else if (oper === "-") {
        return a - b;
    } else {
        return a * b;
    }
};

const make = (stack, bit) => {
    for (let i = 1; i < N - 1; i += 2) {
        if ((bit & (1 << Math.floor(i / 2))) === 0) {
            stack.push(arr[i]);
            stack.push(arr[i + 1]);
        } else {
            stack.push(calculate(arr[i], stack.pop(), arr[i + 1]));
        }
    }
};

const update = (stack) => {
    let num = stack[0];
    for (let i = 1; i < stack.length - 1; i += 2) {
        num = calculate(stack[i], num, stack[i + 1]);
    }
    if (num > max) {
        max = num;
    }
};

const r_perm = (n, bit) => {
    if (n === len) {
        let stack = [];
        stack.push(arr[0]);
        make(stack, bit);
        update(stack);
        return;
    }
    r_perm(n + 1, bit);
    if ((bit & (1 << (n - 1))) === 0) {
        r_perm(n + 1, bit | (1 << n));
    }
};

r_perm(0, 0);
console.log(max);

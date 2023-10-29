const { isBuffer } = require("util");

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [r, c, k] = input[0].split(" ").map(Number);
const map = [];
for (let i = 1; i <= 3; i++) {
    map.push(input[i].split(" ").map(Number));
}
for (let i = 0; i < 97; i++) {
    map.push([]);
}

let maxR = 3;
let maxC = 3;

const operR = () => {
    let max = -Infinity;
    for (let i = 0; i < maxR; i++) {
        const dict = {};
        for (let j = 0; j < maxC; j++) {
            if (map[i][j] === 0) continue;
            if (!dict[map[i][j]]) {
                dict[map[i][j]] = 1;
            } else {
                dict[map[i][j]]++;
            }
        }
        const arr = [];
        for (key in dict) {
            arr.push([key, dict[key]]);
        }
        arr.sort((a, b) => {
            if (a[1] === b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        const len = arr.length * 2;
        const tmp = [];
        for (let j = 0; j < len; j += 2) {
            if (j === 100) break;
            tmp[j] = +arr[j / 2][0];
            tmp[j + 1] = arr[j / 2][1];
        }
        map[i] = tmp;
        max = Math.max(max, len);
    }
    maxC = max;
    for (let i = 0; i < maxR; i++) {
        while (map[i].length < maxC) {
            map[i].push(0);
        }
    }
};

const operC = () => {
    let max = -Infinity;
    const rowLen = [];
    for (let i = 0; i < maxC; i++) {
        const dict = {};
        for (let j = 0; j < maxR; j++) {
            if (map[j][i] === 0) continue;
            if (!dict[map[j][i]]) {
                dict[map[j][i]] = 1;
            } else {
                dict[map[j][i]]++;
            }
        }
        const arr = [];
        for (key in dict) {
            arr.push([key, dict[key]]);
        }
        arr.sort((a, b) => {
            if (a[1] === b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        const len = arr.length * 2;
        rowLen[i] = len;
        const tmp = [];
        for (let j = 0; j < len; j += 2) {
            if (j === 100) break;
            tmp[j] = +arr[j / 2][0];
            tmp[j + 1] = arr[j / 2][1];
        }
        for (let j = 0; j < len; j++) {
            map[j][i] = tmp[j];
        }
        max = Math.max(max, len);
    }
    maxR = max;
    for (let i = 0; i < maxC; i++) {
        for (let j = rowLen[i]; j < maxR; j++) {
            map[j][i] = 0;
        }
    }
};

let time = 0;

while (time <= 100) {
    if (map[r - 1][c - 1] === k) {
        console.log(time);
        process.exit(0);
    }
    if (maxR >= maxC) {
        operR();
    } else {
        operC();
    }
    time++;
}

console.log(-1);

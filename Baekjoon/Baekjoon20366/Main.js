const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const N = +input[0];
const arr = input[1].split(" ").map(Number);
arr.sort((a, b) => a - b);
let min = Infinity;
for (let i = 0; i < N; i++) {
    for (let j = i + 3; j < N; j++) {
        let left = i + 1;
        let right = j - 1;
        while (left < right) {
            const elsa = arr[j] + arr[i];
            const anna = arr[right] + arr[left];
            if (Math.abs(elsa - anna) < min) {
                min = Math.abs(elsa - anna);
            }
            if (elsa < anna) {
                right--;
            } else if (elsa > anna) {
                left++;
            } else {
                break;
            }
        }
    }
}

console.log(min);

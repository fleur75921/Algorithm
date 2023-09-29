const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
const works = Array(N + 2).fill(0);
for (let i = 2; i < 2 + M; i++) {
    const [a, b, k] = input[i].split(" ").map(Number);
    works[a] += k;
    works[b + 1] -= k;
}

for (let i = 1; i < N; i++) {
    works[i + 1] = works[i + 1] + works[i];
}
for (let i = 0; i < N; i++) {
    arr[i] += works[i + 1];
}

console.log(arr.join(" "));

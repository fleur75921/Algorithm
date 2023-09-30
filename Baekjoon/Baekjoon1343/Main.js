const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim();

let cnt = 0;
const ans = [];
// let isFail = false;
for (let i = 0; i < input.length; i++) {
    if (input.charAt(i) === "X") {
        cnt++;
        if (cnt === 4) {
            ans.push("AAAA");
            cnt = 0;
        }
        if (i === input.length - 1 && cnt === 2) {
            ans.push("BB");
            cnt = 0;
        }
    } else {
        if (cnt > 0) {
            if (cnt !== 2) {
                break;
            } else {
                ans.push("BB");
                ans.push(".");
                cnt = 0;
            }
        } else {
            ans.push(".");
        }
    }
}

if (cnt !== 0) {
    console.log(-1);
} else {
    console.log(ans.join(""));
}

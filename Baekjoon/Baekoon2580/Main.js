const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n");

const matrix = [];
for (let i = 0; i < 9; i++) {
    matrix.push(input[i].split(" "));
}

const row = [];
const col = [];
for (let i = 0; i < 9; i++) {
    const rowTmp = [];
    const colTmp = [];
    const rowTmp2 = [];
    const colTmp2 = [];
    for (let j = 0; j < 9; j++) {
        rowTmp[matrix[i][j]] = true;
        colTmp[matrix[j][i]] = true;
    }
    for (let j = 1; j <= 9; j++) {
        if (!rowTmp[j]) {
            rowTmp2.push(j);
        }
        if (!colTmp[j]) {
            colTmp2.push(j);
        }
    }
    row[i] = rowTmp2;
    col[i] = colTmp2;
}
const area = [];
let r = 0,
    c = 0,
    cnt = 0;
while (r != 9) {
    let tmp = [];
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            tmp[matrix[r + i][c + j]] = true;
        }
    }
    if (c === 6) {
        r += 3;
        c = 0;
    } else {
        c += 3;
    }
    let tmp2 = [];
    for (let i = 1; i <= 9; i++) {
        if (!tmp[i]) {
            tmp2.push(i);
        }
    }
    area[cnt] = tmp2;
    cnt++;
}

const res = [];

const backtrack = (r, c) => {
    if (r === 9) {
        for (let i = 0; i < 9; i++) {
            res.push(matrix[i].join(" "));
        }
        console.log(res.join("\n"));
        process.exit(0);
    }

    let area_r = Math.floor(r / 3);
    let area_c = Math.floor(c / 3);
    let area_num = area_r * 3 + area_c;

    if (matrix[r][c] === "0") {
        const candidate = row[r].filter(
            (item) => col[c].includes(item) && area[area_num].includes(item)
        );

        if (candidate.length === 0) {
            return false;
        }

        candidate.forEach((item) => {
            row[r] = row[r].filter((tmp) => tmp != item);
            col[c] = col[c].filter((tmp) => tmp != item);
            area[area_num] = area[area_num].filter((tmp) => item != tmp);
            matrix[r][c] = item;
            let result;
            if (c != 8) {
                result = backtrack(r, c + 1);
            } else {
                result = backtrack(r + 1, 0);
            }
            if (!result) {
                matrix[r][c] = "0";
                row[r].push(item);
                col[c].push(item);
                area[area_num].push(item);
            }
        });
    } else {
        if (c != 8) {
            result = backtrack(r, c + 1);
        } else {
            result = backtrack(r + 1, 0);
        }
    }
};

backtrack(0, 0);

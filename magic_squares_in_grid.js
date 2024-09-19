/* The task is to find total numbers of 3 x 3 (contiguous) Magic Square subgrids in the given grid.
 A Magic square is a 3 x 3 grid filled with all distinct numbers from 1 to 9 
 such that each row, column, and both diagonals have equal sum.
  the fact is that a subgrid is a Magic Square if its middle element is 5.
 */

var numMagicSquaresInside = function (grid) {
    debugger;
    let ans = 0;
    for(let i=0; i< grid.length-2; i++){
        for(let j=0; j< grid[i].length-2; j++){

            if(grid[i+1][j+1] != 5){
                continue;
            } else{

                if(magic(grid[i][j], grid[i][j+1],grid[i][j+2],
                    grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2],
                    grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2])){
                        ans+=1;
                }
            }
        }
    }

    return ans;
};

function magic(a, b, c, d, e, f, g, h, i) {
    const set = new Set([a, b, c, d, e, f, g, h, i]);
    console.log(set.size);

    if (set.size == 9) {
        for (let i of set) { 
            if (!(i < 10)) {
                return false;
            }
        }
        if ((a + b + c) == 15 && (d + e + f) == 15 && (g + h + i) == 15 &&
            (a + d + g) == 15 && (b + e + h) == 15 && (c + f + i) == 15 &&
            (a + e + i) == 15 && (g + e + c) == 15) {
            return true;
        }
    }

    return false;

}

var G =[[3,10,2,3,4],[4,5,6,8,1],[8,8,1,6,8],[1,3,5,7,1],[9,4,9,2,9]];
// function call to print required answer
console.log( numMagicSquaresInside(G));
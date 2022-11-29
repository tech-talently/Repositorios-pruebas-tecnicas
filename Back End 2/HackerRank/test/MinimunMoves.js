// There are two arrays of integers, arr1 and
// arr2. One move is defined as an increment or
// decrement one of element in an     array.
// Determine the number of moves will it take to match the array
// arr1 with the array arr2. No reordering of
// the digits is allowed.

// Example
// arr1 = [123, 543]
// arr2 = [321, 279]

// Match arr1[0]=123 with arr2[0]=321.
// Increment 1 twice to get 3 (2 moves)
// Decrement 3 twice to get 1 (2 moves).
// 4 moves are needed to match 123 with 321.
// Match arr1[1]=543 with arr2[1]=279.
// Decrement 5 three times to get 2 (3 moves)
// Increment 4 three times to get 7 (3 moves)
// Increment 3 six times to get 9 (6 moves).
// 12 moves are needed to match 543 with 279.
// 16 total moves are needed to match the arrays arr1 and arr2.

function minimumMoves(arr1, arr2) {
  let sumMoves = 0;
  for (let i = 0; i < arr1.length; i++) {
    let movesArr1 = arr1[i].toString().split("");
    let movesArr2 = arr2[i].toString().split("");
    movesArr1.forEach((x, index) => {
      sumMoves += Math.abs(x - movesArr2[index]);
    });
  }
  return sumMoves;
}

var arr1 = [123, 543];
var arr2 = [321, 279];

minimumMoves(arr1, arr2);

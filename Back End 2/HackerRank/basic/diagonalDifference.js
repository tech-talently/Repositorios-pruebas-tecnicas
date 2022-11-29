function diagonalDifference(arr) {
  // Write your code here
  let sumFirstDiagonal = 0;
  let sumSecondDiagonal = 0;
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[i].length; j++) {
      if (i == j) {
        sumFirstDiagonal += arr[i][j];
        console.log(sumFirstDiagonal);
      } 
      if (i + j == arr.length - 1) {
        sumSecondDiagonal += arr[i][j];
        console.log(sumSecondDiagonal);
      }
    }
  }
  
  console.log('difference', sumFirstDiagonal - sumSecondDiagonal);
  return Math.abs(sumFirstDiagonal - sumSecondDiagonal);
}

var arr = [
  [11, 2, 4],
  [4, 5, 6],
  [10, 8, -12],
];
var arr2 = [
  [1, 2, 3, 12],
  [4, 5, 6, 10],
  [7, 8, 9, 11],
  [0, 3, 4, 15],
];
diagonalDifference(arr);
